package com.example.mock_cgv.src.numberselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.MainActivity;
import com.example.mock_cgv.src.numberselect.interfaces.NumberSelectActivityView;
import com.example.mock_cgv.src.numberselect.models.NumberSelectResponse;
import com.example.mock_cgv.src.select.SelectMovieActivity;

import kotlin.random.Random;

public class NumberSelectActivity extends BaseActivity implements NumberSelectActivityView {

    Button mBtnAdultPlus, mBtnAdultMinus, mBtnStudentPlus, mBtnStudentMinus, mBtnSpecialPlus, mBtnSpecialMinus, mBtnBuy, mBtnExit;
    TextView mTvAdult, mTvStudent, mTvSpecial;
    int mCountAdult = 0, mCountStudent = 0, mCountSpecial = 0, mMovieTimeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_select);

        Intent intent = getIntent();
        mMovieTimeId = intent.getExtras().getInt("movietimeid");


        mBtnAdultMinus = findViewById(R.id.number_select_tv_countAdult_minus);
        mBtnAdultPlus = findViewById(R.id.number_select_tv_countAdult_plus);

        mBtnStudentMinus = findViewById(R.id.number_select_tv_countStudent_minus);
        mBtnStudentPlus = findViewById(R.id.number_select_tv_countStudent_plus);

        mBtnSpecialMinus = findViewById(R.id.number_select_tv_countSpecial_minus);
        mBtnSpecialPlus = findViewById(R.id.number_select_tv_countSpecial_plus);

        mTvAdult = findViewById(R.id.number_select_tv_countAdult);
        mTvSpecial = findViewById(R.id.number_select_tv_countSpecial);
        mTvStudent = findViewById(R.id.number_select_tv_countStudent);

        try {
            mTvAdult.setText(0);
            mTvStudent.setText(0);
            mTvSpecial.setText(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //툴바
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.number_select_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true); //to Display titile
        getSupportActionBar().setTitle("인원 선택");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);


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
                showCustomToast("드로어레이아웃 만들기");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void customOnClick(View view) {
        String temp;
        switch (view.getId()) {
            case R.id.number_select_tv_countAdult_minus:
                if (mCountAdult != 0) {
                    mCountAdult--;
                    temp = Integer.toString(mCountAdult);
                    mTvAdult.setText(temp);
                }
                break;
            case R.id.number_select_tv_countAdult_plus:
                mCountAdult++;
                temp = Integer.toString(mCountAdult);
                mTvAdult.setText(temp);
                break;
            case R.id.number_select_tv_countStudent_minus:
                if (mCountStudent != 0) {
                    mCountStudent--;
                    temp = Integer.toString(mCountStudent);
                    mTvStudent.setText(temp);
                }
                break;
            case R.id.number_select_tv_countStudent_plus:
                mCountStudent++;
                temp = Integer.toString(mCountStudent);
                mTvStudent.setText(temp);
                break;
            case R.id.number_select_tv_countSpecial_minus:
                if (mCountSpecial != 0) {
                    mCountSpecial--;
                    temp = Integer.toString(mCountSpecial);
                    mTvSpecial.setText(temp);
                }
                break;
            case R.id.number_select_tv_countSpecial_plus:
                mCountSpecial++;
                temp = Integer.toString(mCountSpecial);
                mTvSpecial.setText(temp);
                break;
            case R.id.number_select_tv_buy:
                if(mCountAdult==0&&mCountStudent==0&&mCountSpecial==0){
                    showCustomToast("인원을 선택해 주세요");
                }
                else{
                    NumberSelectService numberSelectService = new NumberSelectService(this);
                    numberSelectService.postBuyTicket(mMovieTimeId, mCountAdult, mCountStudent, mCountSpecial);
                }
                break;
            case R.id.number_select_tv_exit:
                showCustomToast("구매취소");
                Intent intent = new Intent(NumberSelectActivity.this, SelectMovieActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    @Override
    public void postBuyTicketSuccess(NumberSelectResponse.Result result) {
        String answer = result.getTotalPrice();
        showCustomToast("구매완료 "+answer + "원 입니다.");
        Intent intent = new Intent(NumberSelectActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void postBuyTicketFail() {

    }
}
