package com.example.mock_cgv.src.main.moviedetail;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.home.NonSwipeViewPager;
import com.example.mock_cgv.src.main.moviedetail.interfaces.MovieDetailActivityView;
import com.example.mock_cgv.src.main.moviedetail.models.LikedResponse;
import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;
import com.example.mock_cgv.src.ticketing.TicketingActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class MovieDetailActivity extends BaseActivity implements MovieDetailActivityView {
    TabLayout mMovieDetailTabLayout;
    NonSwipeViewPager mMovieDetailNonSwipeViewPager;

    //서버로부터 받아올 영화 디테일들
    ArrayList<ActorsName> Actors = new ArrayList<>(); //영화배우들 정보
    String mTitle, mTitleEn, mReleaseDate, mDirector, mDirectorImg, mDirectorEnName, mDescription, mGenre, mThumbnail, mSubImg, mVideo, mActorsName, mActorsEnNmae, mActorsImg, mTicketingRatio;
    int mViewAge, mRunningTime, mGoldenEggRatio;

    Button mBtnLiked;


    ImageView mIvMovieDetailMainImg, mIvMovieDetailSubImg, mIvMovieDetailViewAge;
    TextView mTvMovieDetailTitle, mTvMovieDetailEnTitle, mTvMovieDetailReleaseDate, mTvMovieDetailTicketingRatio;

    Boolean LikedFlag = false;

    //intent로 넘어온 movieid;
    int mMovieId;

    MovieDetailService movieDetailService;

    private MovieDetailCustomDialog mMovieDetailCustomDialog;

    private Boolean mLikedFlag = false;

    String mLoginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //tablayout + nonswipeviewpager
        mMovieDetailNonSwipeViewPager = findViewById(R.id.movie_detail_non_swipe_view_pager);
        mMovieDetailTabLayout = findViewById(R.id.movie_detail_tablayout);


        //ChartRecyclerViewAdapter의 ViewHolder에서 넘어옴(영화 아이디 담아서 넘어옴)
        Intent intent = getIntent();
        mMovieId = intent.getExtras().getInt("movieid");

        //인텐트로 받은 영화 아이디를 사용해서 서버에 영화 상세 정보 요청한다.
        movieDetailService = new MovieDetailService(this, mMovieId);
        movieDetailService.getMovieDetails();
        movieDetailService.getLiked();

        mIvMovieDetailMainImg = findViewById(R.id.movie_detail_main_img);
        mIvMovieDetailSubImg = findViewById(R.id.movie_detail_sub_Image);
        mTvMovieDetailTitle = findViewById(R.id.movie_detail_tv_title);
        mTvMovieDetailEnTitle = findViewById(R.id.movie_detail_tv_en_title);
        mTvMovieDetailReleaseDate = findViewById(R.id.movie_detail_release_date);
        mTvMovieDetailTicketingRatio = findViewById(R.id.movie_detail_tv_book_rate);
        mIvMovieDetailViewAge = findViewById(R.id.movie_detail_iv_view_age);

        //툴바
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.movie_detail_tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //to Display titile
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        mBtnLiked = findViewById(R.id.movie_detail_btn_liked);

        SharedPreferences preferences = getSharedPreferences("test", MODE_PRIVATE);
//        LikedFlag = preferences.getBoolean("LikedFlag", false);
//
//        if (LikedFlag) {
//            Drawable img1 = this.getResources().getDrawable(R.drawable.ic_favorite_red_24dp);
//            mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img1, null, null);
//            mBtnLiked.setTextColor(Color.parseColor("#A52A2A"));
//        } else {
//            Drawable img = this.getResources().getDrawable(R.drawable.ic_favorite_black_24dp);
//            mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
//            mBtnLiked.setTextColor(Color.parseColor("#808080"));
//        }
        mLoginState=sSharedPreferences.getString(X_ACCESS_TOKEN,null);

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

    @Override
    public void GetInfoSuccess(String message, MovieDetailResponse.Result result) {
        //영화 상세 정보 받는다.
        mTitle = result.getTitle();
        mTitleEn = result.getTitleEn();
        mViewAge = result.getViewAge();
        mReleaseDate = result.getReleaseDate();
        mRunningTime = result.getRunningTime();
        mDirector = result.getDirector();
        mDirectorEnName = result.getDirectorEnName();
        mDescription = result.getDescription();
        mGenre = result.getGenre();
        mThumbnail = result.getThumbnail();
        mSubImg = result.getSubImg();
        mVideo = result.getVideo();
        mGoldenEggRatio = result.getGoldenEggRatio();
        mTicketingRatio = result.getTicketingRatio();
        for (int i = 0; i < result.getActors().size(); i++) {
            mActorsName = result.getActors().get(i).actorsName;
            mActorsEnNmae = result.getActors().get(i).actorsEnName;
            mActorsImg = result.getActors().get(i).actorsImg;
            ActorsName actorsName = new ActorsName(mActorsName, mActorsEnNmae, mActorsImg);
            Actors.add(actorsName);

        }

        Glide.with(this).load(mThumbnail).into(mIvMovieDetailMainImg);
        Glide.with(this).load(mSubImg).into(mIvMovieDetailSubImg);
        mTvMovieDetailTitle.setText(mTitle);
        mTvMovieDetailEnTitle.setText(mTitleEn);

        if (mViewAge == 0) mIvMovieDetailViewAge.setImageResource(R.drawable.rating_all);
        else if (mViewAge == 12) mIvMovieDetailViewAge.setImageResource(R.drawable.rating_12);
        else if (mViewAge == 15) mIvMovieDetailViewAge.setImageResource(R.drawable.rating_15);
        else if (mViewAge == 19) mIvMovieDetailViewAge.setImageResource(R.drawable.rating_18);

        //뷰페이져3개 생성
        MovieDetailViewPagerAdapter movieDetailViewPagerAdapter = new MovieDetailViewPagerAdapter(getSupportFragmentManager(), mMovieDetailTabLayout.getTabCount(), result, mMovieId);
        mMovieDetailNonSwipeViewPager.setAdapter(movieDetailViewPagerAdapter);
        mMovieDetailNonSwipeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mMovieDetailTabLayout));
        mMovieDetailTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mMovieDetailNonSwipeViewPager));

        mTvMovieDetailReleaseDate.setText(mReleaseDate);
        mTvMovieDetailTicketingRatio.setText("예매율 " + mTicketingRatio + "% ·");


    }


    @Override
    public void GetInfoFail() {

    }

    @Override
    public void GetLikedSuccess(LikedResponse.Result result) {
        //좋아요 개수 출력
        if(result==null){
            //회색, 0
            mBtnLiked.setText("0");

            Drawable img = this.getResources().getDrawable(R.drawable.ic_favorite_black_24dp);
            mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
            mBtnLiked.setTextColor(Color.parseColor("#808080"));

            LikedFlag=false;
        }else{
            int isliked = result.getIsLiked();

            if(isliked==1){ //좋아요 누른상태
            mBtnLiked.setText(String.valueOf(result.count));
            Drawable img1 = this.getResources().getDrawable(R.drawable.ic_favorite_red_24dp);
            mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img1, null, null);
            mBtnLiked.setTextColor(Color.parseColor("#A52A2A"));
            LikedFlag=true;
            }else{ //좋아요 안누른 상태
                mBtnLiked.setText(String.valueOf(result.count));
                Drawable img = this.getResources().getDrawable(R.drawable.ic_favorite_black_24dp);
                mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
                mBtnLiked.setTextColor(Color.parseColor("#808080"));
                LikedFlag=false;
            }

        }
    }

    @Override
    public void GetLikedFail() {

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.movie_detail_btn_book:
                Intent intent = new Intent(this, TicketingActivity.class);
                intent.putExtra("movieid", mMovieId);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void onclick(View view) {
        showCustomToast("서비스 준비중입니다.");
    }

    //좋아요를 추가 하거나 없앤다. 버튼클릭 이벤트
    public void postLiked(View view) {
        if(mLoginState!=null){
            movieDetailService.postLikedAdd();
        }
        else{
            showCustomToast("로그인 후 이용해 주세요");
        }
    }

    @Override
    public void PostLikedAddSuccess(String message, int code, final LikedResponse.Result result) {

//        String isliked = String.valueOf(result.getIsLiked());
//        if(isliked==null || isliked=="0"){ //회색 (좋아요 취소했을때)
//        }else if(isliked=="1"){ //빨강 (좋아요 했을때)
//        }
        if(LikedFlag==false){
            final Drawable img1 = this.getResources().getDrawable(R.drawable.ic_favorite_red_24dp);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img1, null, null);
                            mBtnLiked.setTextColor(Color.parseColor("#A52A2A"));
                        }
                    });
                }
            }).start();
            LikedFlag=true;

        }else if(LikedFlag==true){
            final Drawable img = this.getResources().getDrawable(R.drawable.ic_favorite_black_24dp);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
                            mBtnLiked.setTextColor(Color.parseColor("#808080"));
                        }
                    });
                }
            }).start();
            LikedFlag=false;

        }

        String count = String.valueOf(result.getCount());
        if(count==null){ //값이 0
            new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mBtnLiked.setText("0");
                        }
                    });
                }
            }).start();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mBtnLiked.setText(String.valueOf(result.getCount()));
                        }
                    });
                }
            }).start();
        }





    }

    @Override
    public void PostLikedAddFail() {

    }

    private View.OnClickListener LikedCancelListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ShowFavoriteBlack();

        }
    };

    public void ShowFavoriteBlack() {
        mMovieDetailCustomDialog.dismiss();
        Drawable img1 = this.getResources().getDrawable(R.drawable.ic_favorite_black_24dp);
        mBtnLiked.setCompoundDrawablesWithIntrinsicBounds(null, img1, null, null);
        mBtnLiked.setTextColor(Color.parseColor("#808080"));



    }

    private View.OnClickListener CancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMovieDetailCustomDialog.dismiss();
        }
    };

}
