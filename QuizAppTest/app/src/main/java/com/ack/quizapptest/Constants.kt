package com.ack.quizapptest

import com.ack.quizapptest.Question

object Constants {

    const val userName: String = "userName"
    const val totalQuestions : String = "totalQuestion"
    const val correctAnswers : String = "correctAnswers"


    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1= Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        questionsList.add(que1)

        val que2= Question(2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Syria",
            "Hungary",
            "Fiji",
            "Germany",
            3
        )
        questionsList.add(que2)

        val que3= Question(3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Brazil",
            "Belgium",
            "Denmark",
            "Austria",
            2
        )
        questionsList.add(que3)

        val que4= Question(4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Japan",
            "Kuwait",
            "Denmark",
            "Brazil",
            4
        )
        questionsList.add(que4)

        val que5= Question(5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Russia",
            "Turkey",
            "England",
            1
        )
        questionsList.add(que5)

        val que6= Question(6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Uruguay",
            "China",
            "New Zealand",
            "Italy",
            3
        )
        questionsList.add(que6)

        val que7= Question(7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Paraguay",
            "France",
            "Hungary",
            1
        )
        questionsList.add(que7)

        val que8= Question(8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Spain",
            "England",
            "Italy",
            1
        )
        questionsList.add(que8)

        val que9= Question(9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Kenya",
            "Pakistan",
            "Tajikistan",
            "India",
            4
        )
        questionsList.add(que9)


        return questionsList
    }

}