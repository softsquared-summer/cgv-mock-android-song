package com.example.mock_cgv.src.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.login.LogInActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity implements MainActivityView {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private Context mContext = this;

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
        mDrawerLayout = (DrawerLayout)findViewById(R.id.main_dl_drawer_layout);
        if(mDrawerLayout.isDrawerOpen(Gravity.RIGHT)){
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
        }else {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }

    }
    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_tv_login:
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ticket:
                showCustomToast("티켓 예약하세요");
                return true;
            case R.id.menu_popcorn:
                showCustomToast("팝콘사세유");
                return true;
            case R.id.menu_menu:
                if(!mDrawerLayout.isDrawerOpen(Gravity.RIGHT)){
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



//    private void tryGetTest() {
//        showProgressDialog();
//        final MainService mainService = new MainService(MainActivity.this);
//        mainService.getTest();
//    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();

    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }
}

