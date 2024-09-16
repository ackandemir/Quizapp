package com.ack.quizapptest

data class Question(
    val id: Int,
    val question: String,
    val image: Int, // ByteArray yapardik genelde
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
