package com.example.kidsquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.kidsquiz.R;

public class HomeSliderAdapter extends PagerAdapter {
    private Context context;

    public HomeSliderAdapter(Context context) {
        this.context = context;
    }


    /*
    This callback is responsible for creating a page. We inflate the layout and set the drawable
    to the ImageView based on the position. In the end we add the inflated layout to the parent
    container .This method returns an object key to identify the page view, but in this example page view
    itself acts as the object key
    */

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_slider, null);
        ImageView imageView = view.findViewById(R.id.imgslider);
        imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }

    private int getImageAt(int position) {
        switch (position) {
            case 0:
              return R.drawable.rabbit;

            case 1:
                return R.drawable.elephant;

            case 2:
                return R.drawable.bird;

            case 3:
                return R.drawable.cow;

            default:
                return R.drawable.rabbit;
        }
    }
}
