package com.example.quizpedia

object Constants {

    const val USER_NAME : String = "username"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANS : String = "Correct_ans"

    fun getQuestions(): ArrayList<Questions> {

        val questionList = ArrayList<Questions>()

        val q1 = Questions(1,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_argentina,"Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1)
        questionList.add(q1)

        val q2 = Questions(2,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_belgium,"Brazil",
            "Germany",
            "Belgium",
            "Belarus",
            3)
        questionList.add(q2)

        val q3 = Questions(3,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_brazil,"Brazil",
            "Brunei",
            "Belize",
            "Spain",
            1)
        questionList.add(q3)

        val q4 = Questions(4,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_denmark,"Switzerland",
            "Dominica",
            "Egypt",
            "Denmark",
            4)
        questionList.add(q4)

        val q5 = Questions(5,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_fiji,"Gabon",
            "Fiji",
            "Finland",
            "None of these",
            2)
        questionList.add(q5)

        val q6 = Questions(6,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_germany,"Greece",
            "Georgia",
            "Armenia",
            "Germany",
            4)
        questionList.add(q6)

        val q7 = Questions(2,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_australia,"Angola",
            "Australia",
            "Armenia",
            "USA",
            2)
        questionList.add(q7)

        val q8 = Questions(8,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_india,"India",
            "Ireland",
            "Indonesia",
            "Hungary",
            1)
        questionList.add(q8)

        val q9 = Questions(9,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_kuwait,"Kenya",
            "Jordan",
            "Kuwait",
            "Sudan",
            3)
        questionList.add(q9)

        val q10 = Questions(10,
            "What country does this flag belong to ?",
            R.drawable.ic_flag_of_new_zealand,"New Zealand",
            "USA",
            "Armenia",
            "Austria",
            1)
        questionList.add(q10)




        return questionList
    }
}