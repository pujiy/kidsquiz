package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.LessonLettersAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonLettersActivity extends AppCompatActivity {

    private static ViewPager pager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z};
    private int[] audio = {R.raw.a, R.raw.b, R.raw.letterc, R.raw.letterd, R.raw.lettere, R.raw.letterf, R.raw.letterg, R.raw.letterh, R.raw.letteri, R.raw.letterj, R.raw.letterk, R.raw.letterl, R.raw.letterm, R.raw.lettern, R.raw.lettero, R.raw.letterp, R.raw.letterq, R.raw.letterr, R.raw.letters, R.raw.lettert, R.raw.letteru, R.raw.letterv, R.raw.letterw, R.raw.letterx, R.raw.lettery, R.raw.letterz };
    private ArrayList<Integer> lessonLettersData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonLettersAudioData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_letters);

        AudioPlayNotLoop.playAudio(LessonLettersActivity.this, R.raw.a);

        showLesson();

        for (int i=0; i<img.length; i++) {
            lessonLettersAudioData.add(audio[i]);
        }

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(LessonLettersActivity.this, lessonLettersAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }

    private void showLesson() {
        for (int i=0; i<img.length; i++)
            lessonLettersData.add(img[i]);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new LessonLettersAdapter(lessonLettersData, LessonLettersActivity.this));
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
        Intent moveToCat = new Intent(LessonLettersActivity.this, CategoryActivity.class);
        startActivity(moveToCat);

    }
}
