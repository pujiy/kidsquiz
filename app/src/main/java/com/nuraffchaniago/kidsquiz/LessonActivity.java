package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.LessonAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.animals_bird, R.drawable.animals_cat, R.drawable.animals_cow, R.drawable.animals_dog, R.drawable.animals_elephant, R.drawable.animals_frog, R.drawable.animals_monkey, R.drawable.animals_panda, R.drawable.animals_rabbit, R.drawable.animals_fish};
    private int[] audio = new int[] {R.raw.bird, R.raw.cat, R.raw.cow, R.raw.dog, R.raw.elephant, R.raw.frog, R.raw.monkey, R.raw.panda, R.raw.rabbit, R.raw.fish};
    private ArrayList<Integer> lessonAnimalsData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonAnimalAudioData = new ArrayList<Integer>();



    @Override
    public void onBackPressed() {
        AudioPlay.isplayingAudio = false;
        Intent moveToCat = new Intent(LessonActivity.this, CategoryActivity.class);
        startActivity(moveToCat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);


        AudioPlayNotLoop.playAudio(LessonActivity.this, R.raw.bird);

        init();

        for (int i = 0; i < img.length; i++) {
            lessonAnimalAudioData.add(audio[i]);
        }

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(LessonActivity.this, lessonAnimalAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


    }

    private void init() {


        for (int i = 0; i < img.length; i++) {
            lessonAnimalsData.add(img[i]);


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new LessonAdapter(lessonAnimalsData, LessonActivity.this));


        //circle indicator
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == img.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);

            }
        };



    }
    }



}
