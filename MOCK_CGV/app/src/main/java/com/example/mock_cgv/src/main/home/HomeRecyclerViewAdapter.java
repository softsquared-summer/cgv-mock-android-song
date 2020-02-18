package com.example.mock_cgv.src.main.home;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mock_cgv.R;

import java.util.ArrayList;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mData=null;

    // 아이템 뷰를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_home_video_view;
        TextView tv_home_movie_title;
        TextView tv_home_movie_detail;
        TextView tv_home_detail_view;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            //뷰 객체에 대한 참조
            iv_home_video_view=itemView.findViewById(R.id.home_video_view);
            tv_home_movie_title=itemView.findViewById(R.id.home_movie_title);
            tv_home_movie_detail=itemView.findViewById(R.id.home_movie_detail);
            tv_home_detail_view=itemView.findViewById(R.id.home_detail_view);
        }
    }

    //생성자에서 데이터 리스트 객체를 전달받음
    HomeRecyclerViewAdapter(ArrayList<String> list){
        mData=list;
    }

    //onCreateViewHolder : 아이템 뷰를 위한 뷰홀더 객체 생성해서 리턴함
    @Override
    public HomeRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.home_recyclerview_item,parent,false);
        HomeRecyclerViewAdapter.ViewHolder vh = new HomeRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    //onBindViewHolder position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = mData.get(position);
//        holder.textView1.setText(text);
        holder.tv_home_detail_view.setText(text);
        holder.tv_home_movie_detail.setText(text);
        holder.tv_home_movie_detail.setText(text);
        holder.iv_home_video_view.setImageResource(R.drawable.movie);
    }

    //getItemCount 전체 데이터 갯수 리턴
    @Override
    public int getItemCount() {
        return mData.size();
    }

}
