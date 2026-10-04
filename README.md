# Student Profile Editor

A simple Android app built with Jetpack Compose to practice basic state handling and UI structure.

## Features

- Edit student name and course
- Save the entered information
- Switch between editing mode and display mode
- Edit the saved information again without losing the values

## Concepts Practiced

- `@Composable`
- `Column`
- `Text`
- `TextField`
- `Button`
- `Modifier`
- `padding`
- `fillMaxWidth`
- `remember`
- `mutableStateOf`
- `if / else`
- State hoisting
- `(String) -> Unit`
- `() -> Unit`

## App Flow

The app starts in editing mode:

1. Enter the student's name
2. Enter the course
3. Press **SAVE**
4. The entered information is displayed
5. Press **EDIT** to return to editing mode

## Screenshots

### Editing Mode

![Editing Screen](./screenshots/Editing-page.png)

### Display Mode

![Display Screen](./screenshots/Display-Page.png)

## Built With

- Kotlin
- Jetpack Compose
- Android Studio

## Purpose

This project was created as a small practice exercise to understand basic Jetpack Compose concepts, sspecially state, callbacks and state hoisting.
