package com.example.mock_cgv.src.ticketing;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.login.LogInActivity;
import com.example.mock_cgv.src.numberselect.NumberSelectActivity;
import com.example.mock_cgv.src.ticketing.interfaces.TicketingActivityView;
import com.example.mock_cgv.src.ticketing.models.TicketDetailResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingSecondResponse;

import java.util.ArrayList;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class TicketingActivity extends BaseActivity implements TicketingActivityView {

    Context mContext;
    String title,viewAge,runningTime,thumbnail,date,week;
    TextView TvTitle,TvViewAge,TvRunningTime,TvDate;
    ImageView IvThumbNail;
    RecyclerView mRecyclerView;
    TicketingTheaterRecyclerViewAdapter mTicketingTheaterRecyclerViewAdapter;
    int mMovieId;
    private TicketingCustomDialog mTicketingCustomDialog;

    ArrayList<TheaterInfo> theaters = new ArrayList<>();
    ArrayList<TimeTableInfo> timetables = new ArrayList<>();

    String mLoginState;


    //예매할때 인원 수 체크
    int mCountAdult=0;
    int mCountStudent=0;
    int mCountSpecial=0;

    int adultWhere=R.id.book_dialog_countAdult;
    int studentWhere=R.id.book_dialog_countStudent;
    int specialWhere=R.id.book_dialog_countSpecial;

    int mMovieTimeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketing);


        //툴바
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.ticketing_tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true); //to Display titile
        getSupportActionBar().setTitle("영화별 예매");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        //intent로 받은 movie아이디 보낸다.
        Intent intent = getIntent();
        mMovieId = intent.getExtras().getInt("movieid");

        TicketingService ticketingService = new TicketingService(this);
        ticketingService.getTicketingSelect(mMovieId);

        TvTitle=findViewById(R.id.ticketing_tv_title);
        TvViewAge=findViewById(R.id.ticketing_tv_view_age);
        TvRunningTime=findViewById(R.id.ticketing_tv_running_time);
        TvDate=findViewById(R.id.ticketing_tv_date);
        IvThumbNail=findViewById(R.id.ticketing_iv_thumbnail);

        //로그인 여부 판단 할 때 사용
        mLoginState=sSharedPreferences.getString(X_ACCESS_TOKEN,null);

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

    @Override
    public void getMovieTimeTableSuccess(TicketingSecondResponse.Result result) {

        if(result!=null){
            String theaterId = result.getTheaterId();
            String theaterName = result.getTheaterName();
            String date = result.getDate();
            String uniqueMovieTimeId,uniqueRoomId,startTime,endTime,seatCount,totalSeat;
            Log.e("dklsfdlk",""+result.getTime().size());
            for(int i=0;i<result.getTime().size();i++){
                uniqueMovieTimeId=result.getTime().get(i).getUniqueMovieTimeId();
                uniqueRoomId=result.getTime().get(i).getUniqueRoomId();
                startTime=result.getTime().get(i).getStartTime();
                endTime=result.getTime().get(i).getEndTime();



                seatCount=result.getTime().get(i).getSeatCount();
                totalSeat=result.getTime().get(i).getTotalSeat();
                TimeTableInfo timeTableInfo = new TimeTableInfo(uniqueMovieTimeId,uniqueRoomId,startTime,
                        endTime,seatCount,totalSeat);
                timetables.add(timeTableInfo);
            }
        }
//        Log.e("dkdkdkdk",""+timetables.size());
//        for(int i=0;i<timetables.size();i++){
//            Log.e("dkdkdkdk",""+timetables.get(i).getStartTime());
//            Log.e("dkdkdkdk",""+timetables.get(i).getEndTime());
//
//        }


        mRecyclerView=findViewById(R.id.ticketing_recycler_movie_theater);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        mTicketingTheaterRecyclerViewAdapter = new TicketingTheaterRecyclerViewAdapter(this,theaters,timetables,this);
        mRecyclerView.setAdapter(mTicketingTheaterRecyclerViewAdapter);

    }

    @Override
    public void getMovieTimeTableFail() {

    }

    @Override
    public void getMovieSelectSuccess(ArrayList<TicketingResponse.Result> results) {
            title = results.get(0).getTitle();
            viewAge = results.get(0).getViewAge();
            runningTime = results.get(0).getRunningTime();
            thumbnail = results.get(0).getThumbnail();
            date = results.get(0).getDate();
            week = results.get(0).getWeek();
            for (int j = 0; j < results.get(0).getTheaters().size(); j++) {
                String theaterRoomid = results.get(0).getTheaters().get(j).getTheaterRoomId();
                String theaterid = results.get(0).getTheaters().get(j).getTheaterId();
                String theaterName = results.get(0).getTheaters().get(j).getTheaterName();
                String floor = results.get(0).getTheaters().get(j).getFloor();
                String roomid = results.get(0).getTheaters().get(j).getRoomId();
                TheaterInfo theaterInfo = new TheaterInfo(theaterRoomid, theaterid, theaterName, floor, roomid);
                theaters.add(theaterInfo);
            }
            TvDate.setText(date);
            TvRunningTime.setText(runningTime+"분");
            TvViewAge.setText(viewAge+"세 이용가 · ");
            TvTitle.setText(title);
            Glide.with(this).load(thumbnail).into(IvThumbNail);




        if(theaters.size()!=0){
            int theaterid =  Integer.parseInt(theaters.get(0).getTheaterId());

            TicketingSecondService ticketingSecondService1=new TicketingSecondService(mMovieId,theaterid,this);
            ticketingSecondService1.getMovieTimeTable();
        }

    }

    private View.OnClickListener singlelistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.dialog_btn_choose:
                    mTicketingCustomDialog.dismiss();
                    if(mLoginState!=null){ //로그인 했을 때
                        mTicketingCustomDialog.dismiss();

                        //mMovieTimeId 새로운 액티비티에서 11번 보내버려
                        Intent intent1 = new Intent(TicketingActivity.this, NumberSelectActivity.class);
                        intent1.putExtra("movietimeid",mMovieTimeId);
                        startActivity(intent1);
                    }
                    else{ //로그인 안했을 때
                        mTicketingCustomDialog.dismiss();
                        showCustomToast("로그인 후 이용해 주세요");
                        Intent intent = new Intent(TicketingActivity.this, LogInActivity.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.dialog_iv_close:
                    mTicketingCustomDialog.dismiss();
                    break;
                default:
                    break;
            }
        }
    };



    @Override
    public void getMovieSelectFail() {

    }

    @Override
    public void getTicketDetailSuccess(TicketDetailResponse.Result result, int movieTimeId, int code, String message) {
        //커스텀 다이얼로그 ㄱㄱ
        mMovieTimeId=movieTimeId;
        if(code==100){
            mTicketingCustomDialog = new TicketingCustomDialog(this,singlelistener,result);
            mTicketingCustomDialog.show();

        }
        else{
            showCustomToast(message);
        }
    }


    @Override
    public void getTicketDetailFail() {

    }

    public void goclick(View view) {
        showCustomToast("서비스 준비중 입니다.");
    }
}
