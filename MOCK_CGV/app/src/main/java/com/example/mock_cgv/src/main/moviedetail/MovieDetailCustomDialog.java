package com.example.mock_cgv.src.main.moviedetail;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mock_cgv.R;

public class MovieDetailCustomDialog extends Dialog {

    private TextView mTvLikedCancel,mTvCancel;

    private View.OnClickListener mLikedCancelClickListener;
    private View.OnClickListener mCancelClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.movie_detail_custom_dialog);

        mTvLikedCancel=findViewById(R.id.movie_Detail_custom_dialog_tv_liked_cancel);
        mTvCancel=findViewById(R.id.movie_detail_custom_dialog_tv_cancel);

        //클릭이벤트 세팅
        if(mLikedCancelClickListener!=null && mCancelClickListener!=null){
            mTvLikedCancel.setOnClickListener(mLikedCancelClickListener);
            mTvCancel.setOnClickListener(mCancelClickListener);
        }else if(mLikedCancelClickListener!=null && mCancelClickListener==null){
            mTvLikedCancel.setOnClickListener(mLikedCancelClickListener);
        }else{

        }

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount=0.8f;
        getWindow().setAttributes(layoutParams);
    }

    public MovieDetailCustomDialog(@NonNull Context context,View.OnClickListener likedCancleListener,
                                   View.OnClickListener cancelListener) {
        super(context);
        this.mLikedCancelClickListener=likedCancleListener;
        this.mCancelClickListener=cancelListener;

    }

}
