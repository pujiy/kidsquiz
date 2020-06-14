package com.nuraffchaniago.kidsquiz;

import android.provider.BaseColumns;

public final class QuizContractWord {

    public QuizContractWord() {
    }

    public static class QuestionTableWord2 implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questionsword";
        public static final String COLUMN_QUESTION = "question_word";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
    }
}
