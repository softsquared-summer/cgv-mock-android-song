package com.example.mock_cgv.src.main.my;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseFragment;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class MyFragment extends BaseFragment {

    String mLoginState;
    TextView mTvMyShowId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_my,container,false);
//        mTvMyShowId=rootView.findViewById(R.id.my_tv_show_id);

//
//        //TODO 로그인->로그아웃 상태바꼈을때 UI가 그대로임 해결할것
//        //null이면 로그아웃 상태, null아니면 로그인 상태
//        mLoginState=sSharedPreferences.getString(X_ACCESS_TOKEN,null);
//        if(mLoginState==null){
//            mTvMyShowId.setText("로그인 후 이용해주세요");
//        }else{
//            //TODO 아이디값 받아와서 뿌릴것
//            mTvMyShowId.setText("안녕하세요");
//        }



        return rootView;
    }
}
