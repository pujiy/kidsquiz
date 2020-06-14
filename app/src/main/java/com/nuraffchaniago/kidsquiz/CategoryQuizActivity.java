package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CategoryQuizActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_quiz);

        if(AudioPlay.isplayingAudio == true) {
           Log.d("isiaudio", "true");


        }
        else {
            Log.d("isiaudio",  "false");
        }




        CardView btnQuizImage = findViewById(R.id.card_quizimage);
        btnQuizImage.setOnClickListener(this);

        CardView btnQuizWord = findViewById(R.id.card_quizword);
        btnQuizWord.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        AudioPlay.stopAudio();
        Intent moveToMain = new Intent(CategoryQuizActivity.this, MainActivity.class);
        startActivity(moveToMain);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_quizimage:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveQuizImage = new Intent(CategoryQuizActivity.this, QuizActivity.class);
                startActivity(moveQuizImage);
                break;

            case R.id.card_quizword:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveQuizWord = new Intent(CategoryQuizActivity.this, QuizWordActivity.class);
                startActivity(moveQuizWord);
                break;

        }
    }

}