package com.example.mock_cgv.src.main.moviedetail.movieinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseFragment;

public class MovieInfoFragment extends BaseFragment   {

    TextView mTvGenre, mTvRunTime, mTvViewAge;
    String mGenre, mRuntime, mViewage;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_movie_info, container, false);

        mTvGenre = rootview.findViewById(R.id.movie_info_tv_genre);
        mTvRunTime = rootview.findViewById(R.id.movie_info_tv_running_time);
        mTvViewAge = rootview.findViewById(R.id.movie_info_tv_view_age);

        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mTvGenre.setText(bundle.getString("genre"));
            mTvRunTime.setText(String.valueOf(bundle.getInt("runtime"))+"분");
            mTvViewAge.setText(String.valueOf(bundle.getInt("viewage"))+"세 관람가");
        }



        return rootview;
    }

}
