package com.example.mock_cgv.src.main.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.signup.interfaces.SignUpActivityView;

public class SignUpActivity extends BaseActivity implements SignUpActivityView {
    EditText mEdtSignUpId,mEdtSignUpPwd,mEdtSignUpEmail,mEdtSignUpName,mEdtSignUpBirthday;
    TextView mTvSignUpMale,mTvSignUpFemale,mTvSignUpSignUp;
    String mId="",mPwd="",mEmail="",mName="";
    int mBirthday=0,mSexState=3;

    TextView mTvManBlack,mTvManRed,mTvFemaleBlack,mTvFemaleRed;

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

        mEdtSignUpBirthday=(EditText)findViewById(R.id.sign_up_edt_birthday);
        mTvSignUpSignUp=(TextView)findViewById(R.id.sign_up_tv_sign_up);

        //툴바
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.signup_tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //to Display titile
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

        mTvManBlack=findViewById(R.id.sign_up_male_black);
        mTvManRed=findViewById(R.id.sign_up_man_red);
        mTvFemaleBlack=findViewById(R.id.sign_up_female_black);
        mTvFemaleRed=findViewById(R.id.sign_up_female_red);

        mTvManBlack.setVisibility(View.VISIBLE);
        mTvManRed.setVisibility(View.INVISIBLE);
        mTvFemaleBlack.setVisibility(View.VISIBLE);
        mTvFemaleRed.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.signup_tv_male:
                mSexState=1;
//                showCustomToast("남자");
                mTvManBlack.setVisibility(View.INVISIBLE);
                mTvManRed.setVisibility(View.VISIBLE);
                mTvFemaleBlack.setVisibility(View.VISIBLE);
                mTvFemaleRed.setVisibility(View.INVISIBLE);
                break;
            case R.id.signup_tv_female:
                mSexState=2;
//                showCustomToast("여자");
                mTvFemaleBlack.setVisibility(View.INVISIBLE);
                mTvFemaleRed.setVisibility(View.VISIBLE);
                mTvManBlack.setVisibility(View.VISIBLE);
                mTvManRed.setVisibility(View.INVISIBLE);
                break;
            case R.id.sign_up_tv_sign_up:
                try {
                    mId=mEdtSignUpId.getText().toString();
                    mPwd=mEdtSignUpPwd.getText().toString();
                    mEmail=mEdtSignUpEmail.getText().toString();
                    mName=mEdtSignUpName.getText().toString();
                    mBirthday=Integer.parseInt(mEdtSignUpBirthday.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                sendPostSignUp(mId,mPwd,mEmail,mName,mSexState,mBirthday);
                break;
            default:
                break;
        }
    }
    private void sendPostSignUp(String userId ,String pw ,String email ,String userName ,int sex ,int birth ){
        showProgressDialog();
        SignUpService signUpService = new SignUpService(this);
        signUpService.getSignUp(userId, pw, email, userName, sex, birth);
    }

    @Override
    public void SignUpFail() {
        hideProgressDialog();
        showCustomToast("실패");
    }

    @Override
    public void SignUpSuccess(String message, int code) {
        hideProgressDialog();
        showCustomToast(message);

        if(code==100){
            onBackPressed();
        }
    }


}
