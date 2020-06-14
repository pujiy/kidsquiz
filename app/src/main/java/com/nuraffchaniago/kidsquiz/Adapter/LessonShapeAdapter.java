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

public class LessonShapeAdapter extends PagerAdapter {
    private ArrayList<Integer> lessonsShape;
    private LayoutInflater inflater;
    private Context context;

    public LessonShapeAdapter(ArrayList<Integer> lessonsShape, Context context) {
        this.lessonsShape = lessonsShape;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return lessonsShape.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout  = inflater.inflate(R.layout.lesson_shape_slider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imglessonsshapes);


        Glide.with(context)
                .load(lessonsShape.get(position))
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
