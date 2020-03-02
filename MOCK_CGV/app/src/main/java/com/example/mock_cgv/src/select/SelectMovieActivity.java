package com.example.mock_cgv.src.select;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseActivity;
import com.example.mock_cgv.src.select.interfaces.SelectMovieActivityView;
import com.example.mock_cgv.src.select.models.SelectMovieResponse;

import java.util.ArrayList;

public class SelectMovieActivity extends BaseActivity implements SelectMovieActivityView {

    ArrayList<SelectMovieData> items = new ArrayList<>();
    SelectMovieRecyclerAdapter mSelectMovieRecyclerAdapter;
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_movie);



        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.select_movie_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true); //to Display titile
        getSupportActionBar().setTitle("영화선택");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        mRecyclerView=findViewById(R.id.select_movie_recycler);
        SelectMovieService selectMovieService = new SelectMovieService(this);
        selectMovieService.getMovieSelect();

        int spanCount=3;
        int spacing =5;
        boolean includeEdge =false;
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        //툴바
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //툴바
        switch (item.getItemId()) {
            case R.id.menu2_menu:
                showCustomToast("아직");
                return true;
            case android.R.id.home :
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void getMovieListSuccess(ArrayList<SelectMovieResponse.Result> results) {
        int id;
        String title,thunmbnail;
        for(int i=0;i<results.size();i++){
            id=results.get(i).getId();
            title=results.get(i).getTitle();
            thunmbnail=results.get(i).getThumbnail();

            SelectMovieData selectMovieData = new SelectMovieData(thunmbnail,title,id);
            items.add(selectMovieData);

            int numberOfColumns = 3;
            mRecyclerView.setLayoutManager(new GridLayoutManager(this,numberOfColumns));
            mSelectMovieRecyclerAdapter = new SelectMovieRecyclerAdapter(items);
            mRecyclerView.setAdapter(mSelectMovieRecyclerAdapter);
        }
    }

    @Override
    public void getMovieListFail() {

    }
}
