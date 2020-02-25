package com.example.mock_cgv.src.main.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.MainActivity;
import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.login.interfaces.LogInActivityView;
import com.example.mock_cgv.src.main.signup.SignUpActivity;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class LogInActivity extends BaseActivity implements LogInActivityView {
    EditText mEdtUserId,mEdtPwd;
    String mUserId,mPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //툴바
        androidx.appcompat.widget.Toolbar login_toolbar=findViewById(R.id.login_tb_toolbar);
        login_toolbar.setTitle("로그인");
        setSupportActionBar(login_toolbar);

        //로그인
        mEdtUserId=(EditText)findViewById(R.id.login_edt_userid);
        mEdtPwd=(EditText)findViewById(R.id.login_edt_pwd);

    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_tv_signup:
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.login_tv_login:
                mUserId=mEdtUserId.getText().toString();
                mPwd=mEdtPwd.getText().toString();
                sendPostLogIn(mUserId,mPwd);
                break;
            default:
                break;
        }
    }

    private void sendPostLogIn(String mUserId, String mPwd) {
        showProgressDialog();
        LogInService logInService = new LogInService(this);
        logInService.getLogIn(mUserId,mPwd);

    }

    @Override
    public void LogInFail() {
        showCustomToast("실패");
        hideProgressDialog();
    }

    @Override
    public void LogInSuccess(String message, int code, String jwt) {
        hideProgressDialog();
        if(code==100){
            //값저장
            SharedPreferences.Editor editor = sSharedPreferences.edit();
            editor.putString(X_ACCESS_TOKEN, jwt);
            editor.commit();

            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else if(code==200){
            showCustomToast(message);
        }

    }

}
