package com.example.kidsquiz;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.kidsquiz.Model.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = SharedPrefmanager.getInstance(this).getUser();

        TextView tvUsername = findViewById(R.id.tv_user);
        tvUsername.setText(user.getName());

        CardView btnLessons = findViewById(R.id.card_lessons);
        btnLessons.setOnClickListener(this);

        CardView btnLeaderboard = findViewById(R.id.card_ranking);
        btnLeaderboard.setOnClickListener(this);

        CircleImageView ivProfile = findViewById(R.id.iv_imguser);
        ivProfile.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_lessons:
                Intent moveLessons = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(moveLessons);
                break;

            case R.id.card_ranking:
                Intent moveLeaderboard = new Intent(MainActivity.this, LeaderboardActivity.class);
                startActivity(moveLeaderboard);
                break;

            case R.id.iv_imguser:
                Intent moveProfile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(moveProfile);
                break;
        }
    }
}
