package com.example.soundofanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "" ;
    private ImageView dog,monkey;
    private MediaPlayer mp;
    Random random;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();


        dog = findViewById(R.id.dog);
        monkey = findViewById(R.id.monkey);



        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dog.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_down_anim));
                mp = MediaPlayer.create(MainActivity.this,R.raw.dog);
                mp.start();
            }
        });
        monkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monkey.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce_anim));
                int randomSound = random.nextInt(3);
                Log.d(TAG, "onClick: " + randomSound);

                switch (randomSound){
                    case 0:
                        mp = MediaPlayer.create(MainActivity.this,R.raw.monkey0);
                        break;
                    case 1:
                        mp = MediaPlayer.create(MainActivity.this,R.raw.monkey1);
                        break;
                    case 2:
                        mp = MediaPlayer.create(MainActivity.this,R.raw.monkey2);
                        break;
                }
                mp.start();
            }
        });
    }
}