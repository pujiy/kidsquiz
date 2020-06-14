package com.nuraffchaniago.kidsquiz;

import android.provider.BaseColumns;

public final class QuizContract {

    public QuizContract() {
    }

    public static class QuestionTable implements BaseColumns {

        public static final String TABLE_NAME = "quiz_questions2";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_QUESTION_IMAGE  = "question_image";
        public static final String COLUMN_QUESTION_TYPE_ANSWER = "type_answer";
        public static final String COLUMN_QUESTION_TYPE_QUESTION  = "type_question";
        public static final String COLUMN_QUESTION_SOUND = "question_sound";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";


    }
}
