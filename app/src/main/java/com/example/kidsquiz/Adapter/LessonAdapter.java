package com.example.kidsquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.kidsquiz.LessonActivity;
import com.example.kidsquiz.R;

import java.util.ArrayList;

public class LessonAdapter extends PagerAdapter {

    private ArrayList<Integer> lessonAnimals;
    private LayoutInflater inflater;
    private Context context;

    public LessonAdapter(Context context, ArrayList<Integer> lessonAnimals) {
        this.context = context;
        this.lessonAnimals = lessonAnimals;
        inflater = LayoutInflater.from(context);


    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return lessonAnimals.size();
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View myImageLayout  = inflater.inflate(R.layout.lessonslider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imglesson);
        myImage.setImageResource(lessonAnimals.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }


}
