package com.example.mock_cgv.src.main.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.MainService;
import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.signup.interfaces.SignUpActivityView;

import okhttp3.OkHttpClient;

public class SignUpActivity extends BaseActivity implements SignUpActivityView {
    EditText mEdtSignUpId,mEdtSignUpPwd,mEdtSignUpEmail,mEdtSignUpName,mEdtSignUpBirthday;
    TextView mTvSignUpMale,mTvSignUpFemale,mTvSignUpSignUp;
    String mId,mPwd,mEmail,mName;
    int mBirthday,mSexState=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mEdtSignUpId=(EditText)findViewById(R.id.signup_edt_id);
        mEdtSignUpPwd=(EditText)findViewById(R.id.signup_edt_password);
        mEdtSignUpEmail=(EditText)findViewById(R.id.signup_edt_email);
        mEdtSignUpName=(EditText)findViewById(R.id.signup_edt_name);
        mTvSignUpMale=(TextView) findViewById(R.id.signup_tv_male);
        mTvSignUpFemale=(TextView)findViewById(R.id.signup_tv_female);
        mEdtSignUpBirthday=(EditText)findViewById(R.id.signup_edt_birthday);
        mTvSignUpSignUp=(TextView)findViewById(R.id.signup_tv_signup);
    }
    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.signup_tv_signup:
                mId=mEdtSignUpId.getText().toString();
                mPwd=mEdtSignUpPwd.getText().toString();
                mEmail=mEdtSignUpEmail.getText().toString();
                mName=mEdtSignUpName.getText().toString();
                mBirthday=Integer.parseInt(mEdtSignUpBirthday.getText().toString());
                sendPostSignUp(mId,mPwd,mEmail,mName,mSexState,mBirthday);
                break;
            case R.id.signup_tv_male:
                mSexState=1;
                showCustomToast("남자");
                break;
            case R.id.signup_tv_female:
                mSexState=2;
                showCustomToast("여자");
                break;
            default:
                break;
        }
    }
    private void sendPostSignUp(String userId ,String pw ,String email ,String userName ,int sexStatus ,int ageStatus ){
        showProgressDialog();
        SignUpService signUpService = new SignUpService(this);
        signUpService.getSignUp(userId, pw, email, userName, sexStatus, ageStatus);
    }

    @Override
    public void SignUpFail() {
        hideProgressDialog();
        showCustomToast("실패");
    }

    @Override
    public void SignUpSuccess(String message) {
        hideProgressDialog();
        showCustomToast(message);
    }


}
