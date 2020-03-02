package com.example.mock_cgv.src.ticketing;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.ticketing.interfaces.TicketingActivityView;
import com.example.mock_cgv.src.ticketing.models.TicketDetailResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingResponse;
import com.example.mock_cgv.src.ticketing.models.TicketingSecondResponse;

import java.util.ArrayList;

public class TicketingTheaterRecyclerViewAdapter extends RecyclerView.Adapter<TicketingTheaterRecyclerViewAdapter.ViewHolder>  {

    private ArrayList<TheaterInfo> infos=null;
    private ArrayList<TimeTableInfo> tables=null;
    LinearLayout timetable1,timetable2,timetable3,showdetail1,showdetail2,showdetail3;
    private Context context;
     TicketingActivityView ticketingActivityView;

    public TicketingTheaterRecyclerViewAdapter(Context context,ArrayList<TheaterInfo> theaterInfos,ArrayList<TimeTableInfo> timetables,TicketingActivityView ticketingActivityView) {
        this.infos=theaterInfos;
        this.tables=timetables;
        this.context=context;
        this.ticketingActivityView=ticketingActivityView;
    }

    @NonNull
    @Override
    public TicketingTheaterRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticketing_theater_recycler_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketingTheaterRecyclerViewAdapter.ViewHolder holder, int position) {
        String theaterRoomId,theaterId,theaterName,floor,roomid;


        theaterId=infos.get(position).getTheaterId();
        theaterName=infos.get(position).getTheaterName();
        theaterRoomId=infos.get(position).getTheaterRoomId();
        floor=infos.get(position).getFloor();
        roomid=infos.get(position).getRoomid();

        holder.TvMovieTheater.setText(theaterName);

        try {
            holder.TvStartTime1.setText(tables.get(0).getStartTime());
            holder.TvSeatCount1.setText(tables.get(0).getSeatCount());
            holder.TvEndTime1.setText("~"+tables.get(0).getEndTime());
            holder.TvTotalSeat1.setText("/"+tables.get(0).getTotalSeat()+"석");

        } catch (Exception e) {
            timetable1.setVisibility(View.INVISIBLE);
            timetable2.setVisibility(View.INVISIBLE);
            timetable3.setVisibility(View.INVISIBLE);
            e.printStackTrace();
        }

        try {
            holder.TvStartTime2.setText(tables.get(1).getStartTime());
            holder.TvEndTime2.setText("~"+tables.get(1).getEndTime());
            holder.TvSeatCount2.setText(tables.get(1).getSeatCount());
            holder.TvTotalSeat2.setText("/"+tables.get(1).getTotalSeat()+"석");

        } catch (Exception e) {
            timetable2.setVisibility(View.INVISIBLE);
            timetable3.setVisibility(View.INVISIBLE);

            e.printStackTrace();
        }

        try {
            holder.TvStartTime3.setText(tables.get(2).getStartTime());
            holder.TvEndTime3.setText("~"+tables.get(2).getEndTime());
            holder.TvSeatCount3.setText(tables.get(2).getSeatCount());
            holder.TvTotalSeat3.setText("/"+tables.get(2).getTotalSeat()+"석");

        } catch (Exception e) {
            timetable3.setVisibility(View.INVISIBLE);

            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
//        return infos.size();
        return 1;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView TvMovieTheater;
        Context context;
        TextView TvStartTime1,TvStartTime2,TvStartTime3,TvEndTime1,TvEndTime2,TvEndTime3
                ,TvSeatCount1,TvSeatCount2,TvSeatCount3,TvTotalSeat1,TvTotalSeat2,TvTotalSeat3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TvMovieTheater=itemView.findViewById(R.id.ticketing_theater_recycler_btn_button);
            TvStartTime1=itemView.findViewById(R.id.ticketing_theater_recycler_start_time_1);
            TvStartTime2=itemView.findViewById(R.id.ticketing_theater_recycler_start_time_2);
            TvStartTime3=itemView.findViewById(R.id.ticketing_theater_recycler_start_time_3);
            TvEndTime1=itemView.findViewById(R.id.ticketing_theater_recycler_end_time_1);
            TvEndTime2=itemView.findViewById(R.id.ticketing_theater_recycler_end_time_2);
            TvEndTime3=itemView.findViewById(R.id.ticketing_theater_recycler_end_time_3);
            TvSeatCount1=itemView.findViewById(R.id.ticketing_theater_recycler_seat_count_1);
            TvSeatCount2=itemView.findViewById(R.id.ticketing_theater_recycler_seat_count_2);
            TvSeatCount3=itemView.findViewById(R.id.ticketing_theater_recycler_seat_count_3);
            TvTotalSeat1=itemView.findViewById(R.id.ticketing_theater_recycler_total_seat_1);
            TvTotalSeat2=itemView.findViewById(R.id.ticketing_theater_recycler_total_seat_2);
            TvTotalSeat3=itemView.findViewById(R.id.ticketing_theater_recycler_total_seat_3);

            timetable1=itemView.findViewById(R.id.ticketing_theater_timetable1);
            timetable2=itemView.findViewById(R.id.ticketing_theater_timetable2);
            timetable3=itemView.findViewById(R.id.ticketing_theater_timetable3);

            context=itemView.getContext();
            TvMovieTheater.setOnClickListener(this);

            showdetail1=itemView.findViewById(R.id.ticketing_show_ticket_detail_1);
            showdetail2=itemView.findViewById(R.id.ticketing_show_ticket_detail_2);
            showdetail3=itemView.findViewById(R.id.ticketing_show_ticket_detail_3);

            showdetail1.setOnClickListener(this);
            showdetail2.setOnClickListener(this);
            showdetail3.setOnClickListener(this);

        }

        //클릭하면 통신해서 받아온다.
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.ticketing_show_ticket_detail_1:
                    try {
                        int movieTimeId1 =  Integer.parseInt(tables.get(0).getUniqueMovieTImeId());

                        TicketDetailService ticketDetailService1 = new TicketDetailService(ticketingActivityView,movieTimeId1);
                        ticketDetailService1.getTicketDetail();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.ticketing_show_ticket_detail_2:
                    try{
                        int movieTimeId2 =  Integer.parseInt(tables.get(1).getUniqueMovieTImeId());
                        TicketDetailService ticketDetailService2 = new TicketDetailService(ticketingActivityView,movieTimeId2);
                        ticketDetailService2.getTicketDetail();

                    } catch (Exception e) {
                        e.printStackTrace();
                    } break;
                case R.id.ticketing_show_ticket_detail_3:
                    try {
                        int movieTimeId3 =  Integer.parseInt(tables.get(2).getUniqueMovieTImeId());
                        TicketDetailService ticketDetailService3 = new TicketDetailService(ticketingActivityView,movieTimeId3);
                        ticketDetailService3.getTicketDetail();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
