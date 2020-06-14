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

public class LessonLettersAdapter extends PagerAdapter {

    private ArrayList<Integer> lessonsLetters;
    private LayoutInflater inflater;
    private Context context;

    public LessonLettersAdapter(ArrayList<Integer> lessonsLetters, Context context) {
        this.lessonsLetters = lessonsLetters;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return lessonsLetters.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout  = inflater.inflate(R.layout.lesson_letters_slider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imglessonletter);


        Glide.with(context)
                .load(lessonsLetters.get(position))
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
