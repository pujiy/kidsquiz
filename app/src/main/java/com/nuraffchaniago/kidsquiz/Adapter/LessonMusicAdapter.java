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

public class LessonMusicAdapter extends PagerAdapter {

    private ArrayList<Integer> lessonsMusics;
    private LayoutInflater inflater;
    private Context context;

    public LessonMusicAdapter(ArrayList<Integer> lessonsMusics, Context context) {
        this.lessonsMusics = lessonsMusics;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return lessonsMusics.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout  = inflater.inflate(R.layout.lesson_music_slider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imglessonmusic);

        Glide.with(context)
                .load(lessonsMusics.get(position))
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
