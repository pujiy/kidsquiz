package com.nuraffchaniago.kidsquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.nuraffchaniago.kidsquiz.R;

import java.util.ArrayList;

public class BodyPartsAdapter extends PagerAdapter {

    private ArrayList<Integer> lessonBodyParts;
    private LayoutInflater inflater;
    private Context context;

    public BodyPartsAdapter(Context context, ArrayList<Integer> lessonAnimals) {
        this.context = context;
        this.lessonBodyParts = lessonAnimals;
        inflater = LayoutInflater.from(context);


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return lessonBodyParts.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout  = inflater.inflate(R.layout.bodyparts_slider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imgbodyparts);
        myImage.setImageResource(lessonBodyParts.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
