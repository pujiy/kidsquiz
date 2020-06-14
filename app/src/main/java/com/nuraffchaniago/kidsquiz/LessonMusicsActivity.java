package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.LessonMusicAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonMusicsActivity extends AppCompatActivity {

    private static ViewPager pager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.cello, R.drawable.drum, R.drawable.guitar, R.drawable.harp, R.drawable.piano, R.drawable.trumpet, R.drawable.violin};
    private int[] audio = {R.raw.cello, R.raw.drum, R.raw.guitar, R.raw.harp, R.raw.piano, R.raw.trumpet, R.raw.violin};
    private ArrayList<Integer> lessonMusicData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonMusicAudioData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_musics);

        AudioPlayNotLoop.playAudio(LessonMusicsActivity.this, R.raw.cello);

        showLesson();

        for (int i=0; i<img.length; i++) {
            lessonMusicAudioData.add(audio[i]);
        }

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(LessonMusicsActivity.this, lessonMusicAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }

    private void showLesson() {
        for (int i=0; i<img.length; i++)
            lessonMusicData.add(img[i]);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new LessonMusicAdapter(lessonMusicData, LessonMusicsActivity.this));
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
        Intent moveToCat = new Intent(LessonMusicsActivity.this, CategoryActivity.class);
        startActivity(moveToCat);

    }
}
