package com.example.mock_cgv.src.main.moviedetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;
import com.example.mock_cgv.src.main.moviedetail.movieinfo.MovieInfoFragment;
import com.example.mock_cgv.src.main.moviedetail.relatednews.RelatedNewFragment;
import com.example.mock_cgv.src.main.moviedetail.review.ReviewFragment;

class MovieDetailViewPagerAdapter extends FragmentStatePagerAdapter {

    private int pageCount;
    MovieDetailResponse.Result mResult;

    public MovieDetailViewPagerAdapter(@NonNull FragmentManager fm, int pageCount, MovieDetailResponse.Result result)
    {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.pageCount=pageCount;
        this.mResult=result;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RelatedNewFragment();
            case 1:
                return new ReviewFragment();
            case 2:
                Bundle bundle = new Bundle();
                MovieInfoFragment movieInfoFragment = new MovieInfoFragment();
                bundle.putString("genre",mResult.getGenre());
                bundle.putInt("runtime",mResult.getRunningTime());
                bundle.putInt("viewage",mResult.getViewAge());
                movieInfoFragment.setArguments(bundle);
                return movieInfoFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageCount;
    }
}
