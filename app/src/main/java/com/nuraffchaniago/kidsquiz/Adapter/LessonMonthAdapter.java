package com.nuraffchaniago.kidsquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.nuraffchaniago.kidsquiz.R;

import java.util.ArrayList;

public class LessonMonthAdapter extends PagerAdapter {

    private ArrayList<Integer> lessonsMonths;
    private LayoutInflater inflater;
    private Context context;

    public LessonMonthAdapter(ArrayList<Integer> lessonsMonths, Context context) {
        this.lessonsMonths = lessonsMonths;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return lessonsMonths.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout  = inflater.inflate(R.layout.lesson_month_slider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imglessonmonth);


        Glide.with(context)
                .load(lessonsMonths.get(position))
                .override(500, 400)
                .fitCenter()
                .into(myImage);

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
