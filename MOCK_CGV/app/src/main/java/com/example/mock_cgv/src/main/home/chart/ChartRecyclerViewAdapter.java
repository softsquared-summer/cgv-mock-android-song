package com.example.mock_cgv.src.main.home.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.session.PlaybackState;
import android.media.tv.TvView;
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
import com.example.mock_cgv.src.ticketing.TicketingActivity;
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

        viewHolder.IvMainImg.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);


        String imageUrl = items.get(position).getImgUrl();
        String title = items.get(position).getTitle();
        String goldeneggratio = Integer.toString(items.get(position).getGoldenEggRatio());
        String ticketingratio = items.get(position).getTicketingRatio();
        viewHolder.TvTitle.setText(title);
        viewHolder.TvGoldenEggRatio.setText(goldeneggratio+"%·");
        viewHolder.TvTicketingRatio.setText("예매율 "+ticketingratio+"%");

        int num = items.get(position).getRnum();
        viewHolder.TvCount.setText(String.valueOf(num));

        int age = items.get(position).getViewAge();
        if(age==0){
            Glide.with(viewHolder.itemView.getContext())
                    .load(R.drawable.rating_all)
                    .into(viewHolder.IvViewAge);
        }else if(age==12){
            Glide.with(viewHolder.itemView.getContext())
                    .load(R.drawable.rating_12)
                    .into(viewHolder.IvViewAge);
        }else if(age==15){
            Glide.with(viewHolder.itemView.getContext())
                    .load(R.drawable.rating_15)
                    .into(viewHolder.IvViewAge);
        }else if(age==19){
            Glide.with(viewHolder.itemView.getContext())
                    .load(R.drawable.rating_18)
                    .into(viewHolder.IvViewAge);
        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView IvMainImg,IvViewAge;
        TextView TvTitle,TvGoldenEggRatio,TvTicketingRatio,TvBookNow,TvCount;
        Context context;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            IvMainImg = itemView.findViewById(R.id.chart_iv_mainImg);
            TvTitle = itemView.findViewById(R.id.chart_tv_title);
            TvGoldenEggRatio=itemView.findViewById(R.id.chart_tv_goldenEggRatio);
            TvTicketingRatio=itemView.findViewById(R.id.chart_tv_ticketingRatio);
            TvBookNow=itemView.findViewById(R.id.chart_book_now);
            TvCount=itemView.findViewById(R.id.chart_tv_count);
            IvViewAge =itemView.findViewById(R.id.chart_iv_view_age);

            context = itemView.getContext();
            IvMainImg.setOnClickListener(this);
            TvBookNow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final Intent intent;
            int movieid = items.get(getAdapterPosition()).getId();
            switch (v.getId())
            {
                case R.id.chart_iv_mainImg:
                    intent= new Intent(context,MovieDetailActivity.class);
                    intent.putExtra("movieid",movieid);
                    context.startActivity(intent);
                    break;
                case R.id.chart_book_now:
                    intent = new Intent(context, TicketingActivity.class);
                    intent.putExtra("movieid",movieid);
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    }


}
