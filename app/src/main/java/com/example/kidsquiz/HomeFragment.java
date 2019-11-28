package com.example.kidsquiz;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kidsquiz.Adapter.HomeSliderAdapter;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private HomeSliderAdapter homeSliderAdapter;
    


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager pager = (ViewPager)view.findViewById(R.id.homepager);
        HomeSliderAdapter homeSliderAdapter = new HomeSliderAdapter(getActivity());
        pager.setAdapter(homeSliderAdapter);
        CircleIndicator circleIndicator = (CircleIndicator)view.findViewById(R.id.homeindicator);
        circleIndicator.setViewPager(pager);
        return view;
    }

}
