package com.nuraffchaniago.kidsquiz.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.nuraffchaniago.kidsquiz.R;

import java.util.ArrayList;

public class LessonAdapter extends PagerAdapter {

    private ArrayList<Integer> lessonAnimals;
    private LayoutInflater inflater;
    private Context context;

    MediaPlayer mp;


    public LessonAdapter(ArrayList<Integer> lessonAnimals, Context context) {
        this.lessonAnimals = lessonAnimals;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
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
        View myImageLayout = inflater.inflate(R.layout.lessonslider, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.imglesson);


        Glide.with(context)
                .load(lessonAnimals.get(position))
                .override(500, 400)
                .fitCenter()
                .into(myImage);


        /*mp = MediaPlayer.create(context, lessonAnimalsAudio.get(position));
        mp.start();

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                mp.stop();
            }
        }); */

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

}
