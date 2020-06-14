package com.nuraffchaniago.kidsquiz;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nuraffchaniago.kidsquiz.Adapter.ColorsAdapter;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ColorsAdapter colorsAdapter;


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_colors, container, false);
        ViewPager pager = (ViewPager)view.findViewById(R.id.pager);
        ColorsAdapter colorsAdapter = new ColorsAdapter(getActivity());
        pager.setAdapter(colorsAdapter);
        CircleIndicator circleIndicator = (CircleIndicator)view.findViewById(R.id.indicator);
        circleIndicator.setViewPager(pager);
        return view;

    /*    pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                AudioPlayNotLoop.playAudio(ColorsFragment.this, lessonFruitsAudioData.get(position));
                Log.d("position", ""+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }


     */

    }

}
