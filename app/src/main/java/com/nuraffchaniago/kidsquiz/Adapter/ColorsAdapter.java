package com.nuraffchaniago.kidsquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.nuraffchaniago.kidsquiz.R;

public class ColorsAdapter extends PagerAdapter {

    private Context context;

    public ColorsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.colors_slider, null);
        ImageView imageView = view.findViewById(R.id.imgslider);
        imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    private int getImageAt(int position) {

        switch (position) {

            case 0:
                return R.drawable.black;

            case 1:
                return R.drawable.blue;

            case 2:
                return R.drawable.green;

            case 3:
                return R.drawable.pink;

            case 4:
                return R.drawable.purple;

            case 5:
                return R.drawable.red;

            case 6:
                return R.drawable.white;

            case 7:
                return R.drawable.yellow;

            default:
                return  R.drawable.black;
        }
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }


}
