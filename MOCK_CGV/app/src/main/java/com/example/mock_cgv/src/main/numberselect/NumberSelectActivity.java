package com.example.mock_cgv.src.main.numberselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.MainActivity;
import com.example.mock_cgv.src.main.numberselect.interfaces.NumberSelectActivityView;
import com.example.mock_cgv.src.main.numberselect.models.NumberSelectResponse;
import com.example.mock_cgv.src.main.select.SelectMovieActivity;

public class NumberSelectActivity extends BaseActivity implements NumberSelectActivityView {

    Button mBtnAdultPlus, mBtnAdultMinus, mBtnStudentPlus, mBtnStudentMinus, mBtnSpecialPlus, mBtnSpecialMinus, mBtnBuy, mBtnExit;
    TextView mTvAdult, mTvStudent, mTvSpecial, mTvMovieTitle, mTvDate, mTvStartDate, mTvEndDate, mTvTheaterName, mTvPaymoney, mTvLastPayMoney, mTvCurrentPayMoney,mTvWon,mTvWonSecond;
    int mCountAdult = 0, mCountStudent = 0, mCountSpecial = 0, mMovieTimeId;
    String mTheaterName, mRoomid, mStratTime, mEndTime, mDate, mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_select);

        Intent intent = getIntent();
        mMovieTimeId = intent.getExtras().getInt("movietimeid");
        mTheaterName = intent.getExtras().getString("theaterName");
        mRoomid = intent.getExtras().getString("roomid");
        mStratTime = intent.getExtras().getString("stratTime");
        mEndTime = intent.getExtras().getString("endTime");
        mDate = intent.getExtras().getString("date");
        mTitle = intent.getExtras().getString("title");

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
        getSupportActionBar().setTitle(mTheaterName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);


        mTvAdult.setText("0");
        mTvStudent.setText("0");
        mTvSpecial.setText("0");

        mTvMovieTitle = findViewById(R.id.number_select_tv_movie_title);
        mTvMovieTitle.setText(mTitle);

        mTvDate = findViewById(R.id.number_select_tv_date);
        mTvDate.setText(mDate);

        mTvStartDate = findViewById(R.id.number_select_tv_start_date);
        mTvStartDate.setText(mStratTime);

        mTvEndDate = findViewById(R.id.number_select_tv_end_date);
        mTvEndDate.setText(mEndTime);

        mTvTheaterName = findViewById(R.id.number_select_tv_theater_name);
        mTvTheaterName.setText(mTheaterName);

        //실시간으로 반응해야됨
        mTvPaymoney = findViewById(R.id.number_select_tv_money);
        mTvLastPayMoney = findViewById(R.id.number_select_last_pay_money);
        mTvCurrentPayMoney = findViewById(R.id.number_select_tv_pay_money);
        mTvWon = findViewById(R.id.number_select_tv_won);
        mTvWonSecond=findViewById(R.id.number_select_won_second);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu2_menu:
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
                    showPayMoney();
                }
                break;
            case R.id.number_select_tv_countAdult_plus:
                mCountAdult++;
                temp = Integer.toString(mCountAdult);
                mTvAdult.setText(temp);
                showPayMoney();
                break;
            case R.id.number_select_tv_countStudent_minus:
                if (mCountStudent != 0) {
                    mCountStudent--;
                    temp = Integer.toString(mCountStudent);
                    mTvStudent.setText(temp);
                    showPayMoney();
                }
                break;
            case R.id.number_select_tv_countStudent_plus:
                mCountStudent++;
                temp = Integer.toString(mCountStudent);
                mTvStudent.setText(temp);
                showPayMoney();
                break;
            case R.id.number_select_tv_countSpecial_minus:
                if (mCountSpecial != 0) {
                    mCountSpecial--;
                    temp = Integer.toString(mCountSpecial);
                    mTvSpecial.setText(temp);
                    showPayMoney();
                }
                break;
            case R.id.number_select_tv_countSpecial_plus:
                mCountSpecial++;
                temp = Integer.toString(mCountSpecial);
                mTvSpecial.setText(temp);
                showPayMoney();
                break;
            case R.id.number_select_tv_buy:
                if (mCountAdult == 0 && mCountStudent == 0 && mCountSpecial == 0) {
                    showCustomToast("인원을 선택해 주세요");
                } else {
                    NumberSelectService numberSelectService = new NumberSelectService(this);
                    numberSelectService.postBuyTicket(mMovieTimeId, mCountAdult, mCountStudent, mCountSpecial);
                }
                break;
//            case R.id.number_select_tv_exit:
//                showCustomToast("구매취소");
//                Intent intent = new Intent(NumberSelectActivity.this, SelectMovieActivity.class);
//                startActivity(intent);
//                break;
            default:
                break;
        }
    }

    //결제해야 하는 금액 보여준다. (3군데)
    private void showPayMoney() {
        int sum = mCountAdult + mCountSpecial + mCountStudent;
        final int money = sum * 10000;

        new Thread(new Runnable() {
            @Override
            public void run() {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            mTvPaymoney.setText(String.valueOf(money));
                            mTvLastPayMoney.setText(String.valueOf(money));
                            mTvCurrentPayMoney.setText(String.valueOf(money));
                            mTvWon.setText("원");
                            mTvWonSecond.setText("원");
                        }
                    });
                }
            }).start();
    }



    @Override
    public void postBuyTicketSuccess(NumberSelectResponse.Result result) {
        String answer = result.getTotalPrice();
        showCustomToast("구매완료");
        Intent intent = new Intent(NumberSelectActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void postBuyTicketFail() {




    }

}
