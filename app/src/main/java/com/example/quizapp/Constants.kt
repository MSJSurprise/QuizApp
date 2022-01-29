package com.example.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val ques1 = Question(1,
            "What country does this flag belong to?",
             R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
             "Armenia",
            "Austria",
            1
            )
        questionList.add(ques1)

        val ques2 = Question(2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Gabon",
            "Sao Tome",
            "Mexico",
            "Kuwait",
            4
        )
        questionList.add(ques2)

        val ques3 = Question(3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Germany",
            "Congo",
            "China",
            1
        )
        questionList.add(ques3)

        val ques4 = Question(4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "Belize",
            "Fiji",
            "Finland",
            3
        )
        questionList.add(ques4)

        val ques5 = Question(5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "France",
            "Fiji",
            "Finland",
            1
        )
        questionList.add(ques5)

        val ques6 = Question(6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "United Kingdom",
            "Iraq",
            "South Africa",
            "Australia",
            4
        )
        questionList.add(ques6)

        val ques7 = Question(7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3
        )
        questionList.add(ques7)

        val ques8 = Question(8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )
        questionList.add(ques8)

        val ques9 = Question(9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            1
        )
        questionList.add(ques9)

        val ques10 = Question(10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Germany",
            "North Korea",
            "Pakistan",
            "Belgium",
            4
        )
        questionList.add(ques10)

        return questionList

    }
}