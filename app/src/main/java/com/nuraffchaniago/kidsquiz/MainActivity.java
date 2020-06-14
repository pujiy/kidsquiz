package com.nuraffchaniago.kidsquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.nuraffchaniago.kidsquiz.Model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer player;
    private boolean audioMute;
    private Button buttonVolume;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //play audio

        audioMute = false;
        User user = SharedPrefmanager.getInstance(this).getUser();

        if(AudioPlay.isplayingAudio == true) {
            Log.d("isiaudio", "true");


        }
        else {
            Log.d("isiaudio",  "false");
            AudioPlay.playAudio(getApplicationContext(), R.raw.backsoundkidsforbeginning);
        }






        CardView btnLessons = findViewById(R.id.card_lessons);
        btnLessons.setOnClickListener(this);

        CardView btnLeaderboard = findViewById(R.id.card_ranking);
        btnLeaderboard.setOnClickListener(this);


        CardView btnPlay = findViewById(R.id.card_play);
        btnPlay.setOnClickListener(this);

        buttonVolume = findViewById(R.id.btn_volume);
        buttonVolume.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
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



            case R.id.card_play:
                Intent movePlay = new Intent(MainActivity.this, CategoryQuizActivity.class);
                startActivity(movePlay);
                break;

            case R.id.btn_volume:
                if(audioMute == false) {
                    audioMute = true;
                    AudioPlay.muteAudio();
                    buttonVolume.setBackground(getDrawable(R.drawable.ic_volume_off_white_50dp));
                }
                else {
                    audioMute = false;
                    AudioPlay.onAudio();
                    buttonVolume.setBackground(getDrawable(R.drawable.ic_volume_up_white_50dp));
                }
        }
    }


    public class AudioInBackground implements LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void matiinAudio() {
            audioMute = true;
        }
    }
}

