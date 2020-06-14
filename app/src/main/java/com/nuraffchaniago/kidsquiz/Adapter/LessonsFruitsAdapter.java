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

public class LessonsFruitsAdapter extends PagerAdapter {

    private ArrayList<Integer> lessonsFruits;
    private LayoutInflater inflater;
    private Context context;

    public LessonsFruitsAdapter(Context context, ArrayList<Integer>lessonsFruits) {
        this.lessonsFruits = lessonsFruits;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return lessonsFruits.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout  = inflater.inflate(R.layout.lessons_fruits_slider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imglessonsfruits);


        Glide.with(context)
                .load(lessonsFruits.get(position))
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
