package com.example.mock_cgv.src.main.home.chart;

import android.content.Context;
import android.content.Intent;
import android.media.session.PlaybackState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mock_cgv.R;
import com.example.mock_cgv.src.main.moviedetail.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChartRecyclerViewAdapter extends RecyclerView.Adapter<ChartRecyclerViewAdapter.ViewHolder>{

    private ArrayList<Chart> items = null;


    public ChartRecyclerViewAdapter(ArrayList<Chart> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ChartRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_recyclerview_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChartRecyclerViewAdapter.ViewHolder viewHolder, int position) {

        Glide.with(viewHolder.itemView.getContext())
                .load(items.get(position).getImgUrl())
                .into(viewHolder.IvMainImg);



        String imageUrl = items.get(position).getImgUrl();
        String title = items.get(position).getTitle();
        String goldeneggratio = Integer.toString(items.get(position).getGoldenEggRatio());
        String ticketingratio = Integer.toString(items.get(position).getTicketingRatio());
        viewHolder.TvTitle.setText(title);
        viewHolder.TvGoldenEggRatio.setText(goldeneggratio);
        viewHolder.TvTicketingRatio.setText(ticketingratio);


    }



    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView IvMainImg;
        TextView TvTitle,TvGoldenEggRatio,TvTicketingRatio,TvBookNow;
        Context context;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            IvMainImg = itemView.findViewById(R.id.chart_iv_mainImg);
            TvTitle = itemView.findViewById(R.id.chart_tv_title);
            TvGoldenEggRatio=itemView.findViewById(R.id.chart_tv_goldenEggRatio);
            TvTicketingRatio=itemView.findViewById(R.id.chart_tv_ticketingRatio);
            TvBookNow=itemView.findViewById(R.id.chart_book_now);

            context = itemView.getContext();
            IvMainImg.setOnClickListener(this);
            TvBookNow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final Intent intent;
            switch (v.getId())
            {
                case R.id.chart_iv_mainImg:
                    int movieid = items.get(getAdapterPosition()).getId();
                    intent= new Intent(context,MovieDetailActivity.class);
                    intent.putExtra("movieid",movieid);
                    context.startActivity(intent);
                    break;
                case R.id.chart_book_now:
                    //TODO 예매창 만드기

                    break;
                default:
                    break;
            }
        }
    }


}
