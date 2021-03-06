package com.example.mock_cgv.src.main.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.MainActivity;

public class SplashActivity extends BaseActivity {
    private final int SPLASH_DISPLAY_TIME=3000;
    ImageView mSplashimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        mSplashimage = findViewById(R.id.splash_iv_splash_image);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
        mSplashimage.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getApplication(),MainActivity.class));
                SplashActivity.this.finish();

            }
        },SPLASH_DISPLAY_TIME);
    }
}
