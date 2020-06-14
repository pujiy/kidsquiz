package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.nuraffchaniago.kidsquiz.Adapter.BodyPartsAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class BodyPartsActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.ear, R.drawable.bodyparts_finger, R.drawable.bodyparts_foot, R.drawable.bodyparts_hair, R.drawable.bodyparts_hand, R.drawable.bodyparts_mouth, R.drawable.bodyparts_nose,R.drawable.bodyparts_eye, R.drawable.bodyparts_teeth, R.drawable.bodyparts_thumb };
    private int[] audio = {R.raw.ear,R.raw.finger,R.raw.foot, R.raw.hair,  R.raw.hand, R.raw.mouth,  R.raw.nose,R.raw.eye,  R.raw.teeth, R.raw.thumb};
    private ArrayList<Integer> lessonBodyPartsData = new ArrayList<Integer>();
    private ArrayList<Integer> lessonBodyPartsAudioData = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);

        AudioPlayNotLoop.playAudio(BodyPartsActivity.this, R.raw.ear);

        init();

        for (int i=0; i<img.length; i++) {
            lessonBodyPartsAudioData.add(audio[i]);
        }

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(BodyPartsActivity.this, lessonBodyPartsAudioData.get(position));
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
        Intent moveToCat = new Intent(BodyPartsActivity.this, CategoryActivity.class);
        startActivity(moveToCat);

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
