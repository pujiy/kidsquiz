package com.example.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.example.kidsquiz.Adapter.BodyPartsAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class BodyPartsActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.ear, R.drawable.finger, R.drawable.foot, R.drawable.hair, R.drawable.hand, R.drawable.mouth, R.drawable.nose,R.drawable.eye, R.drawable.teeth, R.drawable.thumb };
    private ArrayList<Integer> lessonBodyPartsData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);

        init();
    }

    private void init() {

        for (int i=0; i<img.length; i++)
            lessonBodyPartsData.add(img[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new BodyPartsAdapter(BodyPartsActivity.this, lessonBodyPartsData));
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
