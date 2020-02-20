package com.example.mock_cgv.src.main.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.signup.SignUpActivity;

public class LogInActivity extends BaseActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        androidx.appcompat.widget.Toolbar login_toolbar=findViewById(R.id.login_tb_toolbar);
        login_toolbar.setTitle("로그인");
        setSupportActionBar(login_toolbar);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_tv_signup:
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void validateSuccess(String text) {

    }


    @Override
    public void validateFailure(String message) {

    }
}
