package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.placeholder, new ColorsFragment());

        ft.commit();
    }
}
