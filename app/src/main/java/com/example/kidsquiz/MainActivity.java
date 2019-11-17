package com.example.kidsquiz;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView btnCategory = findViewById(R.id.card_lessons);
        btnCategory.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_lessons:

                break;
        }
    }
}
