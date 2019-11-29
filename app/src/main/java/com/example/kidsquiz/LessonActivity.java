package com.example.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.example.kidsquiz.Adapter.LessonAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class LessonActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.bird, R.drawable.cat, R.drawable.cow, R.drawable.dog, R.drawable.elephant, R.drawable.frog, R.drawable.monkey, R.drawable.panda, R.drawable.rabbit, R.drawable.fish};
    private ArrayList<Integer> lessonAnimalsData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        init();
    }

    private void init() {
        for (int i=0; i<img.length; i++)
            lessonAnimalsData.add(img[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new LessonAdapter(LessonActivity.this, lessonAnimalsData));
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
