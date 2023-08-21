package com.sumit.cgc_connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    //variables
    ImageView iconImg,logoImg;
    TextView txtPoweredBy;


    //Animations
    Animation sideAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Hook
        iconImg = findViewById(R.id.img_icon_cgc);
        logoImg = findViewById(R.id.img_logo_cgc);
        txtPoweredBy = findViewById(R.id.txt_powered_by);

        //Animations
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set animantions on elements
        iconImg.setAnimation(sideAnim);
        logoImg.setAnimation(bottomAnim);
        txtPoweredBy.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),OnBoardingScreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);

    }
}