package com.example.mock_cgv.src.main.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.MainActivity;
import com.example.mock_cgv.src.main.login.interfaces.LogInActivityView;
import com.example.mock_cgv.src.main.login.models.LogInResponse;
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
        setSupportActionBar(login_toolbar);
        getSupportActionBar().setTitle("로그인");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);





        //로그인
        mEdtUserId=(EditText)findViewById(R.id.login_edt_userid);
        mEdtPwd=(EditText)findViewById(R.id.login_edt_pwd);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home :
                finish();
                return true;
            case R.id.menu2_menu :
                showCustomToast("드로어레이아웃");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
        showCustomToast("로그인 실패");
        hideProgressDialog();
    }

    @Override
    public void LogInSuccess(String message, LogInResponse.Result result, int code) {
        hideProgressDialog();
        if(code ==100){
            //값저장
            SharedPreferences.Editor editor = sSharedPreferences.edit();
            editor.putString(X_ACCESS_TOKEN, result.getJwt());
            editor.commit();

            showCustomToast("로그인 되었습니다.");
            onBackPressed();
        }
        else{
            showCustomToast(message);
        }
    }



}
