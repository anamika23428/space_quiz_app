package com.example.apace_app.Quiz

data class Question(
    val questionText: String,       // The question text
    val options: List<String>,      // List of options for the question
    val correctOptionIndex: Int     // Index of the correct option in the options list
)

val sampleQuestions = listOf(
    Question(
        questionText = "What is the capital of France?",
        options = listOf("Paris", "London", "Rome", "Berlin"),
        correctOptionIndex = 0  // Paris is the correct answer
    ),
    Question(
        questionText = "Which planet is known as the Red Planet?",
        options = listOf("Earth", "Mars", "Jupiter", "Saturn"),
        correctOptionIndex = 1  // Mars is the correct answer
    ),
    Question(
        questionText = "What is the largest ocean on Earth?",
        options = listOf("Atlantic", "Indian", "Arctic ", "Pacific"),
        correctOptionIndex = 3  // Pacific Ocean is the correct answer
    ),
    Question(
        questionText = "Who wrote 'To Kill a Mockingbird'?",
        options = listOf("Harper Lee", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald"),
        correctOptionIndex = 0  // Harper Lee is the correct answer
    )
)