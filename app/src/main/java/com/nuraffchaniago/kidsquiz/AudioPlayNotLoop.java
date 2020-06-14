package com.nuraffchaniago.kidsquiz;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class AudioPlayNotLoop {
    public static MediaPlayer mediaPlayer;
    private static SoundPool soundPool;
    public static boolean isplayingAudio = false;
    public static void playAudio(Context c, int id) {
        mediaPlayer = MediaPlayer.create(c,id);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        if(!mediaPlayer.isPlaying()) {
            isplayingAudio = true;
            mediaPlayer.start();
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                isplayingAudio = false;
                mp.release();
            }
        });


    }



    public static void stopAudio() {
        isplayingAudio = false;
        mediaPlayer.stop();
        mediaPlayer.release();

    }
}
