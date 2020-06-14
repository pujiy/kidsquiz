package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import com.nuraffchaniago.kidsquiz.Model.Category;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rvCategories;
    private ArrayList<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        if(AudioPlay.isplayingAudio == true) {
            Log.d("isiaudio", "true");

            //AudioPlay.stopAudio();
        }
        else {
            Log.d("isiaudio",  "false");
            AudioPlay.playAudio(getApplicationContext(), R.raw.oldmacdonaldhadafarm);
        }

        CardView catAnimals = findViewById(R.id.catAnimals);
        catAnimals.setOnClickListener(this);

        CardView catBodyParts = findViewById(R.id.catBodyParts);
        catBodyParts.setOnClickListener(this);

        CardView catColors = findViewById(R.id.catColors);
        catColors.setOnClickListener(this);

        CardView catFruits = findViewById(R.id.catFruits);
        catFruits.setOnClickListener(this);

        CardView catLetters = findViewById(R.id.catLetters);
        catLetters.setOnClickListener(this);

        CardView catMonths =findViewById(R.id.catMonths);
        catMonths.setOnClickListener(this);

        CardView catMusics =findViewById(R.id.catMusics);
        catMusics.setOnClickListener(this);

        CardView catNumbers =findViewById(R.id.catNumbers);
        catNumbers.setOnClickListener(this);

        CardView catShapes =findViewById(R.id.catShapes);
        catShapes.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        AudioPlay.stopAudio();
        Intent moveToMain = new Intent(CategoryActivity.this, MainActivity.class);
        startActivity(moveToMain);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.catAnimals:
                if (AudioPlay.isplayingAudio = true) {
                AudioPlay.stopAudio();}
                Intent moveLessonsAnimals = new Intent(CategoryActivity.this, LessonActivity.class);
                startActivity(moveLessonsAnimals);
                break;

            case R.id.catBodyParts:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonsBodyParts = new Intent (CategoryActivity.this, BodyPartsActivity.class);
                startActivity(moveLessonsBodyParts);
                break;

            case R.id.catColors:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonsCOlor = new Intent(CategoryActivity.this, ColorActivity.class);
                startActivity(moveLessonsCOlor);
                break;

            case R.id.catFruits:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonsFruits = new Intent(CategoryActivity.this, LessonsFruitsActivity.class);
                startActivity(moveLessonsFruits);
                break;

            case R.id.catLetters:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonLetters = new Intent(CategoryActivity.this, LessonLettersActivity.class);
                startActivity(moveLessonLetters);
                break;

            case R.id.catMonths:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonMonths = new Intent(CategoryActivity.this, LessonMonthActivity.class);
                startActivity(moveLessonMonths);
                break;

            case R.id.catMusics:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonMusics = new Intent(CategoryActivity.this, LessonMusicsActivity.class);
                startActivity(moveLessonMusics);
                break;

            case R.id.catNumbers:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonNumbers = new Intent(CategoryActivity.this, LessonNumbersActivity.class);
                startActivity(moveLessonNumbers);
                break;

            case R.id.catShapes:
                if (AudioPlay.isplayingAudio = true) {
                    AudioPlay.stopAudio();}
                Intent moveLessonShapes = new Intent(CategoryActivity.this, LessonShapesActivity.class);
                startActivity(moveLessonShapes);
                break;
        }


    }
}
