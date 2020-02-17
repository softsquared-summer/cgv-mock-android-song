package com.example.mock_cgv.src.splash;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

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

//        ActionBar ab = getSupportActionBar();
//        ab.hide();

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
