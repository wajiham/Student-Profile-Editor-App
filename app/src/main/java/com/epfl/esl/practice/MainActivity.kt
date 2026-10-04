package com.epfl.esl.practice

import android.accessibilityservice.AccessibilityService
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epfl.esl.practice.ui.theme.PracticeTheme
import  androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import org.w3c.dom.Text
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Screen()


                }
            }
        }
    }


@Composable
fun Screen(modifier: Modifier= Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var username by remember { mutableStateOf("") }
        var course by remember { mutableStateOf("") }
        var isEditing by remember { mutableStateOf(true) }

        if (isEditing) {
            StudentProfileEditing(

                username = username,
                course = course,
                onUsernameChanged = { newValue -> username = newValue },
                onCourseChanged = { newValue -> course = newValue },
                onSaveButtonClicked = { isEditing = false },


                )
        } else {
            StudentProfileDisplay(
                username = username,
                course = course,
                onEditClicked = { isEditing = true }
            )

        }

    }

}
@Composable
fun StudentProfileEditing(
    username: String,
    course: String,
    onUsernameChanged: (String)-> Unit,
    onCourseChanged:(String) -> Unit,
    onSaveButtonClicked:() -> Unit,
    modifier: Modifier= Modifier

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.student_profile),
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth().padding(top = 60.dp)
        )

        TextField(
            value = username,
            onValueChange = onUsernameChanged,
            label = { Text(stringResource(R.string.name)) },
            textStyle = TextStyle(fontSize = 24.sp),
            modifier = modifier.fillMaxWidth().padding(top = 30.dp)
        )
        TextField(
            value = course,
            onValueChange = onCourseChanged,
            label = { Text(stringResource(R.string.course)) },
            textStyle = TextStyle(fontSize = 24.sp),
            modifier = modifier.fillMaxWidth().padding(top = 30.dp)
        )
        Row(
            modifier = modifier.padding(top = 20.dp)

        ) {
            Button(
                onClick = onSaveButtonClicked,
                modifier = modifier.weight(1f),
            ) {
                Text(text = stringResource(R.string.save_button))
            }

        }
    }
}
    @Composable
fun StudentProfileDisplay(
    username: String,
    course: String,
    onEditClicked:() -> Unit
) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(R.string.student_profile),
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 60.dp)
            )

            Text(
                text = "Name:$username",
                modifier = Modifier.padding(top = 24.dp)
            )
            Text(
                text = "Course: $course",
                modifier = Modifier.padding(top = 24.dp)

            )
            Row(
                modifier = Modifier.padding(top = 20.dp)

            ) {
                Button(
                    onClick = onEditClicked,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = stringResource(R.string.edit_button))
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    PracticeTheme {
        Screen()
    }
}