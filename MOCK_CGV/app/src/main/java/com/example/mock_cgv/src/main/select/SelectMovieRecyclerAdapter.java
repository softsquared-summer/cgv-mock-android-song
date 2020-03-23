package com.example.mock_cgv.src.main.select;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mock_cgv.R;
import com.example.mock_cgv.src.main.ticketing.TicketingActivity;

import java.util.ArrayList;

public class SelectMovieRecyclerAdapter extends RecyclerView.Adapter<SelectMovieRecyclerAdapter.ViewHolder>{

    private ArrayList<SelectMovieData> items = null;

    SelectMovieRecyclerAdapter(ArrayList<SelectMovieData> items){
        this.items=items;
    }

    @NonNull
    @Override
    public SelectMovieRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_movie_recycler_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectMovieRecyclerAdapter.ViewHolder holder, int position) {

        //아이템에서 받아와서 뿌려라.
        String imageUrl = items.get(position).getThumbnail();
        String title = items.get(position).getTitle();

        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .into(holder.IvMainImg);

        holder.TvTitle.setText(title);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView IvMainImg;
        TextView TvTitle;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IvMainImg=itemView.findViewById(R.id.select_movie_recycler_main_image);
            TvTitle=itemView.findViewById(R.id.select_movie_recycler_title);
            IvMainImg.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.DARKEN);

            context=itemView.getContext();
            IvMainImg.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            final Intent intent;
            switch (v.getId())
            {
                case R.id.select_movie_recycler_main_image:
                    int movieid = items.get(getAdapterPosition()).getId();


                    intent= new Intent(context, TicketingActivity.class);
                    intent.putExtra("movieid",movieid);
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }
        }

    }

}
