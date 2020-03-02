package com.example.mock_cgv.src.main.moviedetail;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mock_cgv.src.main.moviedetail.models.MovieDetailResponse;
import com.example.mock_cgv.src.main.moviedetail.movieinfo.MovieInfoFragment;
import com.example.mock_cgv.src.main.moviedetail.relatednews.RelatedNewFragment;
import com.example.mock_cgv.src.main.moviedetail.review.ReviewFragment;

import java.util.ArrayList;

class MovieDetailViewPagerAdapter extends FragmentStatePagerAdapter {

    private int pageCount,mMovieId;
    MovieDetailResponse.Result mResult;


    public MovieDetailViewPagerAdapter(@NonNull FragmentManager fm, int pageCount, MovieDetailResponse.Result result,int movieid)
    {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.pageCount=pageCount;
        this.mResult=result;
        this.mMovieId=movieid;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        switch (position){
            case 0:
                RelatedNewFragment relatedNewFragment = new RelatedNewFragment();
                bundle1.putInt("movieid",mMovieId);
                relatedNewFragment.setArguments(bundle1);
                return relatedNewFragment;
            case 1:
                ReviewFragment reviewFragment = new ReviewFragment();
                bundle2.putInt("movieid",mMovieId);
                reviewFragment.setArguments(bundle2);
                return reviewFragment;
            case 2:
                MovieInfoFragment movieInfoFragment = new MovieInfoFragment();
                bundle3.putString("genre",mResult.getGenre());
                bundle3.putInt("runtime",mResult.getRunningTime());
                bundle3.putInt("viewage",mResult.getViewAge());

                bundle3.putString("director",mResult.getDirector());
                Log.e("d",""+mResult.getDirector());

                bundle3.putString("directorimg",mResult.getDirectorImg());
                bundle3.putString("directorenname",mResult.getDirectorEnName());
                bundle3.putString("video",mResult.getVideo());


                ArrayList<String> ActorsName = new ArrayList<>();
                ArrayList<String> ActorsEnName = new ArrayList<>();
                ArrayList<String> ActorsImg = new ArrayList<>();
                for(int i=0;i<mResult.getActors().size();i++){
                    ActorsName.add(mResult.getActors().get(i).getActorsName());
                    ActorsEnName.add(mResult.getActors().get(i).getActorsEnName());
                    ActorsImg.add(mResult.getActors().get(i).getActorsImg());
                }
                bundle3.putStringArrayList("ActorsName",ActorsName);
                bundle3.putStringArrayList("ActorsEnName",ActorsEnName);
                bundle3.putStringArrayList("ActorsImg",ActorsImg);
                movieInfoFragment.setArguments(bundle3);
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
