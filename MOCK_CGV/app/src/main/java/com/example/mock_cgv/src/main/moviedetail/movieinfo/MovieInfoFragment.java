package com.example.mock_cgv.src.main.moviedetail.movieinfo;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseFragment;

import java.util.ArrayList;

public class MovieInfoFragment extends BaseFragment   {

    TextView mTvGenre, mTvRunTime, mTvViewAge;
    String mGenre, mRuntime, mViewage,mDirector,mDirectorImg,mDirectorEnName,mVideo;

    ArrayList<String> ActorsName = new ArrayList<>();
    ArrayList<String> ActorsEnName = new ArrayList<>();
    ArrayList<String> ActorsImg = new ArrayList<>();

    ImageView mIvActorImg1,mIvActorImg2,mIvActorImg3,mIvActorImg4,mIvActorImg5,mIvDirectorImg;

    TextView mTvActorName1,mTvActorName2,mTvActorName3,mTvActorName4,mTvActorName5,
    mTvActorEnName1,mTvActorEnName2,mTvActorEnName3,mTvActorEnName4,mTvActorEnName5,mTvDirectorName,mTvDirectorEnName;


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

            ActorsName = bundle.getStringArrayList("ActorsName");
            ActorsEnName=bundle.getStringArrayList("ActorsEnName");


            ActorsImg=bundle.getStringArrayList("ActorsImg");
            mDirector=bundle.getString("director");
            mDirectorImg=bundle.getString("directorimg");
            mDirectorEnName=bundle.getString("directorenname");

            mVideo=bundle.getString("video");

        }
        mIvActorImg1=rootview.findViewById(R.id.info_actor1_img);
        mIvActorImg2=rootview.findViewById(R.id.info_actor2_img);
        mIvActorImg3=rootview.findViewById(R.id.info_actor3_img);
        mIvActorImg4=rootview.findViewById(R.id.info_actor4_img);
        mIvActorImg5=rootview.findViewById(R.id.info_actor5_img);

        mTvActorName1=rootview.findViewById(R.id.info_actor1_name);
        mTvActorName2=rootview.findViewById(R.id.info_actor2_name);
        mTvActorName3=rootview.findViewById(R.id.info_actor3_name);
        mTvActorName4=rootview.findViewById(R.id.info_actor4_name);
        mTvActorName5=rootview.findViewById(R.id.info_actor5_name);

        mTvDirectorName=rootview.findViewById(R.id.info_director_name);
        mTvDirectorEnName=rootview.findViewById(R.id.info_director_en_name);
        mIvDirectorImg=rootview.findViewById(R.id.info_tv_director_img);

        mTvActorEnName1=rootview.findViewById(R.id.info_actor1_en_name);
        mTvActorEnName2=rootview.findViewById(R.id.info_actor2_en_name);
        mTvActorEnName3=rootview.findViewById(R.id.info_actor3_en_name);
        mTvActorEnName4=rootview.findViewById(R.id.info_actor4_en_name);
        mTvActorEnName5=rootview.findViewById(R.id.info_actor5_en_name);

        //감독 보여줌
        mTvDirectorName.setText(mDirector);
        mTvDirectorEnName.setText(mDirectorEnName);
        Glide.with(this).load(mDirectorImg).into(mIvDirectorImg);

//        mIvDirectorImg.setBackground(new ShapeDrawable(new OvalShape()));
//        mIvDirectorImg.setClipToOutline(true);

        try {
            Glide.with(this).load(ActorsImg.get(0)).into(mIvActorImg1);
            mTvActorName1.setText(ActorsName.get(0));
            mTvActorEnName1.setText(ActorsEnName.get(0));
//            mIvActorImg1.setBackground(new ShapeDrawable(new OvalShape()));
//            mIvActorImg1.setClipToOutline(true);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ddddd",""+e.getMessage());
        }
        try {
            Glide.with(this).load(ActorsImg.get(1)).into(mIvActorImg2);
            mTvActorName2.setText(ActorsName.get(1));
            mTvActorEnName2.setText(ActorsEnName.get(1));
//            mIvActorImg2.setBackground(new ShapeDrawable(new OvalShape()));
//            mIvActorImg2.setClipToOutline(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glide.with(this).load(ActorsImg.get(2)).into(mIvActorImg3);
            mTvActorName3.setText(ActorsName.get(2));
            mTvActorEnName3.setText(ActorsEnName.get(2));
//            mIvActorImg3.setBackground(new ShapeDrawable(new OvalShape()));
//            mIvActorImg3.setClipToOutline(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glide.with(this).load(ActorsImg.get(3)).into(mIvActorImg4);
            mTvActorName4.setText(ActorsName.get(3));
            mTvActorEnName4.setText(ActorsEnName.get(3));
//            mIvActorImg4.setBackground(new ShapeDrawable(new OvalShape()));
//            mIvActorImg4.setClipToOutline(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glide.with(this).load(ActorsImg.get(4)).into(mIvActorImg5);
            mTvActorName5.setText(ActorsName.get(4));
            mTvActorEnName5.setText(ActorsEnName.get(4));
//            mIvActorImg5.setBackground(new ShapeDrawable(new OvalShape()));
//            mIvActorImg5.setClipToOutline(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootview;
    }

}
