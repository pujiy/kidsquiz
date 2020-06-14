package com.nuraffchaniago.kidsquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.nuraffchaniago.kidsquiz.Model.QuestinWord;
import com.nuraffchaniago.kidsquiz.QuizContract2.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "KidsQuiz3.db";
    private static final int DATABASE_VERSION = 1;


    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;



        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionTable2.TABLE_NAME + " ( " +
                QuestionTable2._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable2.COLUMN_QUESTION + " TEXT, " +
                QuestionTable2.COLUMN_QUESTION_IMAGE + " TEXT, " +
                QuestionTable2.COLUMN_QUESTION_SOUND + " TEXT, " +
                QuestionTable2.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable2.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable2.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable2.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable2.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionTable2.COLUMN_QUESTION_TYPE_ANSWER + " INTEGER, " +
                QuestionTable2.COLUMN_QUESTION_TYPE_QUESTION + " INTEGER " +
                ")";

        final String SQL_CREATE_QUESTION_TABLE_WORD = "CREATE TABLE " +
                QuestionTableWord.TABLE_NAME_WORD + " ( " +
                QuestionTableWord._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTableWord.COLUMN_QUESTION_WORD + " TEXT, " +
                QuestionTableWord.COLUMN_OPTION1_WORD + " TEXT, " +
                QuestionTableWord.COLUMN_OPTION2_WORD + " TEXT, " +
                QuestionTableWord.COLUMN_OPTION3_WORD + " TEXT, " +
                QuestionTableWord.COLUMN_OPTION4_WORD + " TEXT, " +
                QuestionTableWord.COLUMN_ANSWER_NR_WORD + " INTEGER " + ")";


        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        db.execSQL(SQL_CREATE_QUESTION_TABLE_WORD);
        fillQuestionTable();
        fillQuestionTableWord();



    }

    private void fillQuestionTableWord() {
        QuestinWord q1 = new QuestinWord("Violin","watermelon", "apple","violin", "hair", 3);
        addQuestionWord(q1);

        QuestinWord q2 = new QuestinWord("Eye", "hand", "eye","foot", "mouth", 2);
        addQuestionWord(q2);

        QuestinWord q3 = new QuestinWord("Hand", "eye", "foot","hand", "hair", 3);
        addQuestionWord(q3);

        QuestinWord q4 = new QuestinWord("Ear", "ear","mouth","arrow","triangle",1);
        addQuestionWord(q4);

        QuestinWord q5 = new QuestinWord("Foot","foot","mouth","ear","hair",1);
        addQuestionWord(q5);

        QuestinWord q6 = new QuestinWord("Avocado","banana", "avocado","strawberry", "watermelon", 2);
        addQuestionWord(q6);

        QuestinWord q7 = new QuestinWord("Panda","cat", "dog","panda", "elephant", 3);
        addQuestionWord(q7);

        QuestinWord q8 = new QuestinWord("Fish", "fish", "frog","foot", "hand", 1);
        addQuestionWord(q8);

        QuestinWord q9 = new QuestinWord("Elephant", "ear", "fish","apple", "elephant", 4);
        addQuestionWord(q9);

        QuestinWord q10 = new QuestinWord("Rabbit", "banana","apple","arrow","rabbit",4);
        addQuestionWord(q10);

        QuestinWord q11 = new QuestinWord("Dog","cat","cow","dog","fish",3);
        addQuestionWord(q11);

        QuestinWord q12 = new QuestinWord("Black","black_option", "red_option","pink_option", "yellow_option", 1);
        addQuestionWord(q12);

        QuestinWord q13 = new QuestinWord("Pink", "banana","red_option","pink_option","rabbit",3);
        addQuestionWord(q13);

        QuestinWord q14 = new QuestinWord("Yellow","banana","cow","yellow_option","green_option",3);
        addQuestionWord(q14);

        QuestinWord q15 = new QuestinWord("Blue","green_option", "yellow_option","rabbit", "blue_option", 4);
        addQuestionWord(q15);



    }

    private void addQuestionWord(QuestinWord questionWord) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTableWord.COLUMN_QUESTION_WORD, questionWord.getQuestion());
        cv.put(QuestionTableWord.COLUMN_OPTION1_WORD, questionWord.getOption1());
        cv.put(QuestionTableWord.COLUMN_OPTION2_WORD, questionWord.getOption2());
        cv.put(QuestionTableWord.COLUMN_OPTION3_WORD, questionWord.getOption3());
        cv.put(QuestionTableWord.COLUMN_OPTION4_WORD, questionWord.getOption4());
        cv.put(QuestionTableWord.COLUMN_ANSWER_NR_WORD, questionWord.getAnswerNr());
        db.insert(QuestionTableWord.TABLE_NAME_WORD, null, cv);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable2.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTableWord.TABLE_NAME_WORD);
        onCreate(db);

    }

    //Isi Soal
    private void fillQuestionTable() {
        Question2 q1 = new Question2("kosong", "violin", "kosong", "Guitar", "Drum","Violin", "Piano", 3, 1, 2);
        addQuestion(q1);

        Question2 q2 = new Question2("kosong",  "eye", "kosong", "Nose", "Eye","Hair", "Hand", 2, 2, 1);
        addQuestion(q2);

        Question2 q3 = new Question2("kosong",  "hand", "kosong", "Eye", "Foot","Hand", "Hair", 3, 2, 1);
        addQuestion(q3);

        Question2 q4 = new Question2("kosong", "ear", "kosong", "Ear","Mouth","Thumb","Teeth",1,1,1);
        addQuestion(q4);

        Question2 q5 = new Question2("kosong","foot","kosong","Foot","Mouth","Ear","Hair",1,1,1);
        addQuestion(q5);

        Question2 q6 = new Question2("kosong", "mouth", "kosong", "Hand", "Thumb","Nose", "Mouth", 4, 1, 2);
        addQuestion(q6);

        Question2 q7 = new Question2("kosong",  "octagon", "kosong", "Octagon", "Oval","Pentagon", "Square", 1, 2, 1);
        addQuestion(q7);

        Question2 q8 = new Question2("kosong",  "oval", "kosong", "Triangle", "Oval","Star", "Octagon", 2, 2, 1);
        addQuestion(q8);

        Question2 q9 = new Question2("kosong", "pentagon", "kosong", "Octagon","Star","Pentagon","Arrow",3,1,1);
        addQuestion(q9);

        Question2 q10 = new Question2("kosong","square","kosong","Circle","Heart","Arrow","Square",4,1,1);
        addQuestion(q10);

        Question2 q11 = new Question2("kosong", "triangle", "kosong", "Arrow", "Triangle","Square", "Circle", 2, 1, 2);
        addQuestion(q11);

        Question2 q12 = new Question2("kosong",  "arrow", "kosong", "Arrow", "Octagon","Oval", "Triangle", 1, 2, 1);
        addQuestion(q12);

        Question2 q13 = new Question2("kosong",  "circle", "kosong", "Pentagon", "Square","Circle", "Rectangle", 3, 2, 1);
        addQuestion(q13);

        Question2 q14 = new Question2("kosong", "hexagon", "kosong", "Rectangle","Circle","Triangle","Hexagon",4,1,1);
        addQuestion(q14);

        Question2 q15 = new Question2("kosong","apple","kosong","Apple","Watermelon","Banana","Grape",1,1,1);
        addQuestion(q15);

        Question2 q16 = new Question2("kosong", "avocado", "kosong", "Orange", "Avocado","Grape", "Apple", 2, 1, 2);
        addQuestion(q16);

        Question2 q17 = new Question2("kosong",  "banana", "kosong", "Pineapple", "Strawberry","Banana", "Avocado", 3, 2, 1);
        addQuestion(q17);

        Question2 q18 = new Question2("kosong",  "strawberry", "kosong", "Banana", "Apple","Grape", "Strawberry", 4, 2, 1);
        addQuestion(q18);

        Question2 q19 = new Question2("kosong", "watermelon", "kosong", "Banana","Strawberry","Watermelon","Pineapple",3,1,1);
        addQuestion(q19);

        Question2 q20 = new Question2("kosong","hair","kosong","Nose","Thumb","Mouth","Hair",4,1,1);
        addQuestion(q20);

    }

    private void addQuestion(Question2 question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable2.COLUMN_QUESTION, question.getQuestion2());
        cv.put(QuestionTable2.COLUMN_QUESTION_IMAGE, question.getQuestionImage());
        cv.put(QuestionTable2.COLUMN_QUESTION_SOUND, question.getQuestionSound());
        cv.put(QuestionTable2.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable2.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable2.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable2.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionTable2.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionTable2.COLUMN_QUESTION_TYPE_QUESTION, question.getTypeQuestion());
        cv.put(QuestionTable2.COLUMN_QUESTION_TYPE_ANSWER, question.getTypeAnswer());


        db.insert(QuestionTable2.TABLE_NAME, null, cv);
    }

    public List<Question2> getAllQuestions() {
        List<Question2> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable2.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question2 question = new Question2();
                question.setQuestion2(c.getString(c.getColumnIndex(QuestionTable2.COLUMN_QUESTION)));
                question.setQuestionImage(c.getString(c.getColumnIndex(QuestionTable2.COLUMN_QUESTION_IMAGE)));
                question.setQuestionSound(c.getString(c.getColumnIndex(QuestionTable2.COLUMN_QUESTION_SOUND)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable2.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable2.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable2.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable2.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable2.COLUMN_ANSWER_NR)));
                question.setTypeQuestion(c.getInt(c.getColumnIndex(QuestionTable2.COLUMN_QUESTION_TYPE_QUESTION)));
                question.setTypeAnswer(c.getInt(c.getColumnIndex(QuestionTable2.COLUMN_QUESTION_TYPE_ANSWER)));

                questionList.add(question);

            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public List<QuestinWord> getAllQuestionsWord() {
        List<QuestinWord> questionListWord = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTableWord.TABLE_NAME_WORD, null);

        if (c.moveToFirst()) {
            do {
                QuestinWord questionword = new QuestinWord();
                questionword.setQuestion(c.getString(c.getColumnIndex(QuestionTableWord.COLUMN_QUESTION_WORD)));
                questionword.setOption1(c.getString(c.getColumnIndex(QuestionTableWord.COLUMN_OPTION1_WORD)));
                questionword.setOption2(c.getString(c.getColumnIndex(QuestionTableWord.COLUMN_OPTION2_WORD)));
                questionword.setOption3(c.getString(c.getColumnIndex(QuestionTableWord.COLUMN_OPTION3_WORD)));
                questionword.setOption4(c.getString(c.getColumnIndex(QuestionTableWord.COLUMN_OPTION4_WORD)));
                questionword.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTableWord.COLUMN_ANSWER_NR_WORD)));


                questionListWord.add(questionword);

            } while (c.moveToNext());
        }

        c.close();
        return questionListWord;
    }
}
