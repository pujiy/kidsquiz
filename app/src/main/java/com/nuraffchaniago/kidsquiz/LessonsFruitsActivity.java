package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.LessonsFruitsAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonsFruitsActivity extends AppCompatActivity {

    private static ViewPager pager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.fruits_apple, R.drawable.fruits_avocado, R.drawable.fruits_banana, R.drawable.fruits_grape, R.drawable.fruits_orange, R.drawable.fruits_pineapple, R.drawable.fruits_strawberry, R.drawable.fruits_watermelon};
    private int[] audio = {R.raw.apple, R.raw.avocado, R.raw.banana, R.raw.grape, R.raw.orange, R.raw.pineapple, R.raw.strawberry, R.raw.watermelon };
    private ArrayList<Integer> lessonFruitsData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonFruitsAudioData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_fruits);

        AudioPlayNotLoop.playAudio(LessonsFruitsActivity.this, R.raw.apple);

        showLessons();

        for (int i=0; i<img.length; i++) {
            lessonFruitsAudioData.add(audio[i]);
        }

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(LessonsFruitsActivity.this, lessonFruitsAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });



    }

    @Override
    public void onBackPressed() {
        AudioPlay.isplayingAudio = false;
        Intent moveToCat = new Intent(LessonsFruitsActivity.this, CategoryActivity.class);
        startActivity(moveToCat);

    }

    private void showLessons() {

        for (int i=0; i<img.length; i++)
            lessonFruitsData.add(img[i]);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new LessonsFruitsAdapter(LessonsFruitsActivity.this, lessonFruitsData));
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
}
