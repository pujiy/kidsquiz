package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.LessonMonthAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonMonthActivity extends AppCompatActivity {

    private static ViewPager pager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.january, R.drawable.february, R.drawable.march, R.drawable.april, R.drawable.may, R.drawable.june, R.drawable.july, R.drawable.august, R.drawable.september, R.drawable.october, R.drawable.november, R.drawable.december};
    private int[] audio = {R.raw.januari, R.raw.february, R.raw.march, R.raw.april, R.raw.may, R.raw.june, R.raw.july, R.raw.august, R.raw.september, R.raw.october, R.raw.november, R.raw.december};
    private ArrayList<Integer> lessonMonthData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonMonthAudioData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_month);
        AudioPlayNotLoop.playAudio(LessonMonthActivity.this, R.raw.januari);

        showLesson();

        for (int i=0; i<img.length; i++) {
            lessonMonthAudioData.add(audio[i]);
        }

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(LessonMonthActivity.this, lessonMonthAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }

    private void showLesson() {
        for (int i=0; i<img.length; i++)
            lessonMonthData.add(img[i]);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new LessonMonthAdapter(lessonMonthData, LessonMonthActivity.this));
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
        Intent moveToCat = new Intent(LessonMonthActivity.this, CategoryActivity.class);
        startActivity(moveToCat);

    }
}
