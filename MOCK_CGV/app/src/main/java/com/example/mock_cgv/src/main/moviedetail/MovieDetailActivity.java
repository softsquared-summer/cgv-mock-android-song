package com.example.mock_cgv.src.main.moviedetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.MainActivity;
import com.example.mock_cgv.src.main.home.NonSwipeViewPager;
import com.example.mock_cgv.src.main.login.LogInActivity;
import com.example.mock_cgv.src.main.moviedetail.interfaces.MovieDetailActivityView;
import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;
import com.example.mock_cgv.src.main.moviedetail.movieinfo.MovieInfoFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class MovieDetailActivity extends BaseActivity implements MovieDetailActivityView {
    TabLayout mMovieDetailTabLayout;
    NonSwipeViewPager mMovieDetailNonSwipeViewPager;

    //서버로부터 받아올 영화 디테일들
    ArrayList<ActorsName> Actors = new ArrayList<>(); //영화배우들 정보
    String mTitle,mTitleEn,mReleaseDate,mDirector,mDescription,mGenre,mMainImg,mSubImg,mVideo,mActorsName,mActorsEnNmae;
    int mViewAge,mRunningTime,mGoldenEggRatio,mTicketingRatio;

    ImageView mIvMovieDetailMainImg,mIvMovieDetailSubImg;
    TextView mTvMovieDetailTitle,mTvMovieDetailEnTitle,mTvMovieDetailReleaseDate,mTvMovieDetailTicketingRatio;

//    DrawerLayout mDrawerLayout;
//    private TextView mTvDrawerLogin;
//    String mLoginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //tablayout + nonswipeviewpager
        mMovieDetailNonSwipeViewPager = findViewById(R.id.movie_detail_non_swipe_view_pager);
        mMovieDetailTabLayout = findViewById(R.id.movie_detail_tablayout);


        //ChartRecyclerViewAdapter의 ViewHolder에서 넘어옴(영화 아이디 담아서 넘어옴)
        Intent intent = getIntent();
        int movieid = intent.getExtras().getInt("movieid");

        //인텐트로 받은 영화 아이디를 사용해서 서버에 영화 상세 정보 요청한다.
        MovieDetailService movieDetailService = new MovieDetailService(this,movieid);
        movieDetailService.getMovieDetails();

        mIvMovieDetailMainImg = findViewById(R.id.movie_detail_main_img);
        mIvMovieDetailSubImg=findViewById(R.id.movie_detail_sub_Image);
        mTvMovieDetailTitle=findViewById(R.id.movie_detail_tv_title);
        mTvMovieDetailEnTitle=findViewById(R.id.movie_detail_tv_en_title);
        mTvMovieDetailReleaseDate=findViewById(R.id.movie_detail_release_date);
        mTvMovieDetailTicketingRatio=findViewById(R.id.movie_detail_tv_book_rate);

        //툴바
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.movie_detail_tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //to Display titile
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backicon);

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
    public void GetInfoSuccess(String message, MovieDetailResponse.Result result) {
        //영화 상세 정보 받는다.
        Log.e("성공","굿굿");
        mTitle=result.getTitle();
        mTitleEn=result.getTitleEn();
        mReleaseDate=result.getReleaseDate();
        mDirector=result.getDirector();
        mDescription=result.getDescription();
        mGenre=result.getGenre();
        mMainImg=result.getMainImg();
        mSubImg=result.getSubImg();
        mVideo=result.getVideo();
        mViewAge=result.getViewAge();
        mRunningTime=result.getRunningTime();
        mGoldenEggRatio=result.getGoldenEggRatio();
        mTicketingRatio=result.getTicketingRatio();
        for(int i=0;i<result.getActors().size();i++){
            mActorsName=result.getActors().get(i).actorsName;
            mActorsEnNmae=result.getActors().get(i).actorsEnName;
            ActorsName actorsName = new ActorsName(mActorsName,mActorsEnNmae);
            Actors.add(actorsName);

        }

        Glide.with(this).load(mMainImg).into(mIvMovieDetailMainImg);
        Glide.with(this).load(mSubImg).into(mIvMovieDetailSubImg);
        mTvMovieDetailTitle.setText(mTitle);
        mTvMovieDetailEnTitle.setText(mTitleEn);

        //뷰페이져3개 생성
        MovieDetailViewPagerAdapter movieDetailViewPagerAdapter = new MovieDetailViewPagerAdapter(getSupportFragmentManager(), mMovieDetailTabLayout.getTabCount(),result);
        mMovieDetailNonSwipeViewPager.setAdapter(movieDetailViewPagerAdapter);
        mMovieDetailNonSwipeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mMovieDetailTabLayout));
        mMovieDetailTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mMovieDetailNonSwipeViewPager));

        mTvMovieDetailReleaseDate.setText(mReleaseDate+" 개봉");
        mTvMovieDetailTicketingRatio.setText("예매율 "+mTicketingRatio+"% ·");
    }


    @Override
    public void GetInfoFail() {

    }

}