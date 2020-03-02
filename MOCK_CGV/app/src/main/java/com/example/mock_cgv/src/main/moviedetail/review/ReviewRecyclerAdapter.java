package com.example.mock_cgv.src.main.moviedetail.review;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mock_cgv.R;

import java.util.ArrayList;

public class ReviewRecyclerAdapter extends RecyclerView.Adapter<ReviewRecyclerAdapter.ViewHolder> {
    private ArrayList<ReviewData> mData;
    private int mReviewCount;

    public ReviewRecyclerAdapter(ArrayList<ReviewData> mData,int reviewCount) {
        this.mData = mData;
        this.mReviewCount=reviewCount;
    }

    @NonNull
    @Override
    public ReviewRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_recycler_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewRecyclerAdapter.ViewHolder holder, int position) {
//        viewholder.id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
//        viewholder.english.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
//        viewholder.korean.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        holder.TvUserId.setText(mData.get(position).getUserId());
        holder.TvDate.setText(mData.get(position).getDATE());
        holder.TvContent.setText(mData.get(position).getContent());
        int goldenegg=mData.get(position).getGoldenEggStatus();

        if(goldenegg==0){
            holder.IvGoldenEggStatus.setImageResource(R.drawable.ic_broken_egg);
        }
        else{
            holder.IvGoldenEggStatus.setImageResource(R.drawable.ic_egg);
        }
        //TODO 골든에그 상태에 따라 다른 사진 출력
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TvUserId,TvContent,TvDate;
        ImageView IvGoldenEggStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TvContent=itemView.findViewById(R.id.review_recycler_item_content);
            TvDate=itemView.findViewById(R.id.review_recycler_item_date);
            TvUserId=itemView.findViewById(R.id.review_recycler_item_user_id);
            IvGoldenEggStatus=itemView.findViewById(R.id.review_recycler_item_golden_egg_status);
        }
    }
}
