package com.example.febandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimationActivity extends AppCompatActivity {
    ImageView imageView;
    Button BTNblink,BTNrotate,BTNfade,BTNmove,BTNslide,BTNzoom,BTNstop;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animation);
        BTNblink=findViewById(R.id.BTNblink);
        BTNrotate=findViewById(R.id.BTNrotate);
        BTNfade=findViewById(R.id.BTNfade);
        BTNmove=findViewById(R.id.BTNmove);
        BTNslide=findViewById(R.id.BTNslide);
        BTNzoom=findViewById(R.id.BTNzoom);
        BTNstop=findViewById(R.id.BTNstop);
        imageView=findViewById(R.id.imageview);

        BTNblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink_animation);
                imageView.startAnimation(animation);
            }
        });

        BTNrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_animation);
                imageView.startAnimation(animation);
            }
        });

        BTNfade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_animation);
                imageView.startAnimation(animation);

            }
        });

        BTNmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_animation);
                imageView.startAnimation(animation);
            }
        });

        BTNslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_animation);
                imageView.startAnimation(animation);
            }
        });

        BTNzoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_animation);
                imageView.startAnimation(animation);
            }
        });

        BTNstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.clearAnimation();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}