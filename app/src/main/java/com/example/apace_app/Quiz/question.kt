package com.example.apace_app.Quiz

data class Question(
    val questionText: String,       // The question text
    val options: List<String>,      // List of options for the question
    val correctAnswer: String     // Index of the correct option in the options list
)

val sampleQuestions = listOf(
    Question(
        questionText = "What is the closest planet to the Sun?",
        options = listOf("Venus", "Mars", "Earth", "Mercury"),
        correctAnswer = "Mercury"
    ),
    Question(
        questionText = "Which planet is known for its rings?",
        options = listOf("Jupiter", "Saturn", "Uranus", "Neptune"),
        correctAnswer = "Saturn"
    ),
    Question(
        questionText = "What is the brightest star in the night sky?",
        options = listOf("Sirius", "Polaris", "Betelgeuse", "Vega"),
        correctAnswer = "Sirius"
    ),
    Question(
        questionText = "Which planet is called the Red Planet?",
        options = listOf("Earth", "Mars", "Jupiter", "Venus"),
        correctAnswer = "Mars"
    ),
    Question(
        questionText = "What galaxy is Earth located in?",
        options = listOf("Andromeda", "Milky Way", "Sombrero", "Whirlpool"),
        correctAnswer = "Milky Way"
    ),
    Question(
        questionText = "Which planet is known as the Gas Giant?",
        options = listOf("Mars", "Jupiter", "Mercury", "Earth"),
        correctAnswer = "Jupiter"
    ),
    Question(
        questionText = "What is the name of Earth's moon?",
        options = listOf("Luna", "Titan", "Europa", "Phobos"),
        correctAnswer = "Luna"
    ),
    Question(
        questionText = "Which planet has the most moons?",
        options = listOf("Saturn", "Jupiter", "Neptune", "Mars"),
        correctAnswer = "Jupiter"
    ),
    Question(
        questionText = "What is the name of our Sun?",
        options = listOf("Sol", "Star", "Helios", "Apollo"),
        correctAnswer = "Sol"
    ),
    Question(
        questionText = "Which planet is farthest from the Sun?",
        options = listOf("Neptune", "Uranus", "Saturn", "Jupiter"),
        correctAnswer = "Neptune"
    )
)
