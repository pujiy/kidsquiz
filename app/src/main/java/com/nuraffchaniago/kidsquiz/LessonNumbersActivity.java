package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.LessonNumberAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonNumbersActivity extends AppCompatActivity {

    private static ViewPager pager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.lesson_one, R.drawable.lesson_two, R.drawable.lesson_three, R.drawable.lesson_four, R.drawable.lesson_five, R.drawable.lesson_six, R.drawable.lesson_seven, R.drawable.lesson_eight, R.drawable.lesson_nine, R.drawable.lesson_ten};
    private int[] audio = {R.raw.numberone, R.raw.numbertwo, R.raw.numberthree, R.raw.numberfour, R.raw.numberfive, R.raw.numbersix, R.raw.numberseven, R.raw.numbereight, R.raw.numbernine, R.raw.numberten };
    private ArrayList<Integer> lessonNumbersData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonNumbersAudioData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_numbers);
        AudioPlayNotLoop.playAudio(LessonNumbersActivity.this, R.raw.numberone);

        showLessons();

        for (int i=0; i<img.length; i++) {
            lessonNumbersAudioData.add(audio[i]);
        }

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(LessonNumbersActivity.this, lessonNumbersAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });



    }

    private void showLessons() {
        for (int i=0; i<img.length; i++)
            lessonNumbersData.add(img[i]);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new LessonNumberAdapter(lessonNumbersData,LessonNumbersActivity.this));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == img.length) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
    }

    @Override
    public void onBackPressed() {
        AudioPlay.isplayingAudio = false;
        Intent moveToCat = new Intent(LessonNumbersActivity.this, CategoryActivity.class);
        startActivity(moveToCat);

    }
}
