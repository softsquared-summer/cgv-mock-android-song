package com.example.mock_cgv.src.main;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.login.LogInActivity;
import com.example.mock_cgv.src.main.select.SelectMovieActivity;
import com.google.android.material.tabs.TabLayout;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class MainActivity extends BaseActivity implements MainActivityView {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Context mContext = this;

    private DrawerLayout mDrawerLayout;
    private TextView mTvDrawerLogin;
    String mLoginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //툴바
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.main_tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //to Display titile

        //탭레이아웃 + 뷰페이져
        mTabLayout = findViewById(R.id.main_tl_tabLayout);
        mViewPager = findViewById(R.id.main_vp_viewPager);
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mainViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        //드로어 레이아웃
        mTvDrawerLogin = findViewById(R.id.drawer_tv_login);
        mLoginState = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout_dl_drawer_layout);
        if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
        } else {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
        if (mLoginState != null) {
            mTvDrawerLogin.setText("로그아웃");
        } else {
            mTvDrawerLogin.setText("로그인");
        }
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_tv_login:
                String ok = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
                if (mLoginState != null) {
                    showCustomToast("로그아웃 되었습니다.");
                    SharedPreferences.Editor editor = sSharedPreferences.edit();
                    editor.remove(X_ACCESS_TOKEN);
                    editor.commit();
                    mLoginState = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
                    mTvDrawerLogin.setText("로그인");
                } else {
                    Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.drawer_tv_ticketing:
                Intent intent = new Intent(MainActivity.this, SelectMovieActivity.class);
                startActivity(intent);
                break;
//            case R.id.main_logo:
//                Intent intent1 = new Intent(this, MainActivity.class);
//                startActivity(intent1);
//                break;
            case R.id.drawer_tv_ticketing_theater:
                showCustomToast("극장별 예매 준비중입니다");
                break;
            case R.id.drawer_tv_fast_order:
                showCustomToast("패스트오더 준비중입니다");
                break;
            case R.id.drawer_iv_home:
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                break;
            default:
                showCustomToast("서비스 준비중입니다");
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        //툴바
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //툴바
        switch (item.getItemId()) {
            case R.id.menu_ticket:
                showCustomToast("예약 기능 준비중입니다.");
                return true;
            case R.id.menu_popcorn:
                showCustomToast("패스트 오더 기능 준비중입니다.");
                return true;
            case R.id.menu_menu:
                if (!mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();

    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void ShowNotYet(View view) {
        showCustomToast("서비스 준비중 입니다!");
    }

}

