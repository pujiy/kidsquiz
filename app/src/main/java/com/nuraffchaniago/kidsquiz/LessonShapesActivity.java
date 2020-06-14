package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.LessonShapeAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonShapesActivity extends AppCompatActivity {

    private static ViewPager pager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.triangle, R.drawable.star, R.drawable.square, R.drawable.rectangle, R.drawable.pentagon, R.drawable.oval, R.drawable.octagon, R.drawable.hexagon, R.drawable.heart, R.drawable.circle, R.drawable.arrow};
    private int[] audio = {R.raw.triangle, R.raw.star, R.raw.square, R.raw.rectangle, R.raw.pentagon, R.raw.oval, R.raw.octagon, R.raw.hexagon, R.raw.heart, R.raw.cyrcle, R.raw.arrow};
    private ArrayList<Integer> lessonShapesData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonShapesAudioData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_shapes);

        AudioPlayNotLoop.playAudio(LessonShapesActivity.this, R.raw.triangle);

        showLessons();

        for (int i=0; i<img.length; i++) {
            lessonShapesAudioData.add(audio[i]);
        }

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(LessonShapesActivity.this, lessonShapesAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

    }

    private void showLessons() {
        for (int i=0; i<img.length; i++)
            lessonShapesData.add(img[i]);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new LessonShapeAdapter(lessonShapesData,LessonShapesActivity.this));
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
        Intent moveToCat = new Intent(LessonShapesActivity.this, CategoryActivity.class);
        startActivity(moveToCat);

    }
}
