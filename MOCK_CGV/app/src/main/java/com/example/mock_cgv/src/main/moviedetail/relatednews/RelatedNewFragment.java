package com.example.mock_cgv.src.main.moviedetail.relatednews;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseFragment;
import com.example.mock_cgv.src.main.moviedetail.relatednews.interfaces.RelatedNewsFragmentView;
import com.example.mock_cgv.src.main.moviedetail.relatednews.models.RelatedNewsResponse;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class RelatedNewFragment extends BaseFragment implements RelatedNewsFragmentView {

    int mMovieId;
    RelatedNewsService mRelatedNewsService;
    Context context;
    BarChart mAgeBarChart;
    PieChart mSexPieChart;

    private int mTotalCount,mMaleRatio,mFemaleRatio,mTeenAgePercent,mTwentiesPercent,mThirtyPecent,mFourtiesPercent,mFiftiesPercent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_related_new,container,false);

        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mMovieId = bundle.getInt("movieid");
        }

        mRelatedNewsService= new RelatedNewsService(this);
        mRelatedNewsService.getAgeSexDetailInformation(mMovieId);

        context=rootView.getContext();

        mAgeBarChart=rootView.findViewById(R.id.related_news_age_info);
        mSexPieChart=rootView.findViewById(R.id.related_news_sex_info);

        return rootView;
    }


    @Override
    public void getAgeSexDetailInfoSuccess(RelatedNewsResponse.Result result) {
        mTotalCount=result.getTotalCount();
        mMaleRatio=result.getMaleRatio();
        mFemaleRatio=result.getFemaleRatio();
        mTeenAgePercent=result.getTeenAgePercent();
        mTwentiesPercent=result.getTwentiesPercent();
        mThirtyPecent=result.getThirtyPercent();
        mFourtiesPercent=result.getFourtiesPercent();
        mFiftiesPercent=result.getFiftiesPercent();


        //////////////////////////////////////
        ArrayList age = new ArrayList();
        age.add("10대");
        age.add("20대");
        age.add("30대");
        age.add("40대");
        age.add("50대");
        ArrayList Percent = new ArrayList();
        Percent.add(new BarEntry(mTeenAgePercent,0));
        Percent.add(new BarEntry(mTwentiesPercent,1));
        Percent.add(new BarEntry(mThirtyPecent,2));
        Percent.add(new BarEntry(mFourtiesPercent,3));
        Percent.add(new BarEntry(mFiftiesPercent,4));
        BarDataSet barDataSet = new BarDataSet(Percent,"");
//        mAgeBarChart.animate();
        BarData data = new BarData(age,barDataSet);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        mAgeBarChart.setData(data);
        ////////////////////////////////////////
        ArrayList Percent2 = new ArrayList();
        Percent2.add(new Entry(mMaleRatio,0));
        Percent2.add(new Entry(mFemaleRatio,1));
        PieDataSet dataSet = new PieDataSet(Percent2,"");
        ArrayList sex = new ArrayList();
        sex.add("남자");
        sex.add("여자");
        PieData data1 = new PieData(sex,dataSet);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        mSexPieChart.setData(data1);
    }

    @Override
    public void getAgeSexDetailInfoFail() {

    }


}
