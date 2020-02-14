package com.example.mock_cgv.src.main;

import androidx.annotation.Nullable;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.interfaces.MainActivityView;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class MainActivity extends BaseActivity implements MainActivityView {
    private TextView mTvHelloWorld; //안드로이드 지정 변수명 가이드라인

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvHelloWorld = findViewById(R.id.main_tv_hello_world);

    }
    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(MainActivity.this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        mTvHelloWorld.setText(text);

        SharedPreferences.Editor a = sSharedPreferences.edit();
        a.putString(X_ACCESS_TOKEN,text);
        a.apply();

    }
    @Override
    public void validateSuccess201(String text) {
        hideProgressDialog();
        mTvHelloWorld.setText("201"+text); //mainserviec에서 건드리지 말고 인터페이스 만들고 액티비티에서 바꿔라
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message ==null || message.isEmpty() ? getString(R.string.network_error):message);
    }


    public void customOnClick(View view){
        switch (view.getId()){
            case R.id.main_btn_hello_world:
                tryGetTest();
                break;
        }
    }


}
