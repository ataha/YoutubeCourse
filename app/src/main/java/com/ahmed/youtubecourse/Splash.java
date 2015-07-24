package com.ahmed.youtubecourse;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Splash extends ActionBarActivity {

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ourSong = MediaPlayer.create(Splash.this, R.raw.music);
        ourSong.start();
        Thread timer = new Thread() {
            public void run() {

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent opentListActivity = new Intent("com.ahmed.youtubecourse.Menu");
                    startActivity(opentListActivity);
                }
            }
        };
        timer.start();
    }


}