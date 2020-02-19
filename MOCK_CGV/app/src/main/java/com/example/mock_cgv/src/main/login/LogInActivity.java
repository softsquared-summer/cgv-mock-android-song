package com.example.mock_cgv.src.main.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.mock_cgv.R;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        androidx.appcompat.widget.Toolbar login_toolbar=findViewById(R.id.login_tb_toolbar);
        login_toolbar.setTitle("로그인");
        setSupportActionBar(login_toolbar);
    }
}
