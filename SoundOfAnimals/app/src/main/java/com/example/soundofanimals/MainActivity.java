package com.example.soundofanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.apple_text);
        logo = findViewById(R.id.apple_logo);

        textView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_anim));
        logo.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim));
    }
}