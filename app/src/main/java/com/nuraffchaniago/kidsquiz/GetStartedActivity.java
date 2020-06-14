package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStartedActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        Button btngetstarted = findViewById(R.id.btn_get_started);
        btngetstarted.setOnClickListener(this);

        Button btnlogin = findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GetStartedActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXITAPP", true);
        startActivity(intent);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_login:
                Intent movegetstarted = new Intent (GetStartedActivity.this, LoginActivity.class);
                startActivity(movegetstarted);
                break;

            case R.id.btn_get_started:
                Intent movetologin = new Intent (GetStartedActivity.this, LoginActivity.class);
                startActivity(movetologin);
                break;
        }

    }
}
