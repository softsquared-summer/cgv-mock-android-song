package com.example.mock_cgv.src.main.ticketing;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.main.ticketing.models.TicketDetailResponse;

public class TicketingCustomDialog extends Dialog {

    private View.OnClickListener mSingleListener;
    private Context mContext;
    private TicketDetailResponse.Result results;

    protected TicketingCustomDialog(@NonNull Context context, View.OnClickListener singleListener, TicketDetailResponse.Result results) {
        super(context);
        this.mSingleListener = singleListener;
        this.mContext = context;
        this.results = results;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams IpWindow = new WindowManager.LayoutParams();
        IpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        IpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(IpWindow);

        setContentView(R.layout.custom_dialog_ticket_detail);

        TextView mTvTheaterName, mTvRoomId, mTvTotalSeat, mTvDate, mTvStartTime,
                mTvEndTime, mTvSeatCount, mTvDescription;
        Button mBtnChoose;
        ImageView mIvSeatPic,mIvClose;

        mTvTheaterName = findViewById(R.id.dialog_tv_theater_name);
        mTvRoomId = findViewById(R.id.dialog_tv_room_id);
        mTvTotalSeat = findViewById(R.id.dialog_tv_total_seat);
        mIvSeatPic = findViewById(R.id.dialog_iv_seat_pic);
        mTvDate = findViewById(R.id.dialog_tv_date);
        mTvStartTime = findViewById(R.id.dialog_tv_start_time);
        mTvEndTime = findViewById(R.id.dialog_tv_end_time);
        mTvSeatCount = findViewById(R.id.dialog_tv_seat_count);
        mTvDescription = findViewById(R.id.dialog_tv_description);
        mBtnChoose = findViewById(R.id.dialog_btn_choose);
        mIvClose=findViewById(R.id.dialog_iv_close);

        //TODO 생성자로 객채받아서 뿌려줄것(통신으로 받아온다)
        mTvTheaterName.setText(results.getTheaterName());
        mTvRoomId.setText(results.getRoomId()+"관");
        mTvTotalSeat.setText("(총"+results.getTotalSeat()+"명)");
        mIvSeatPic.setImageResource(R.drawable.picpic);
        mTvDate.setText(results.getDate());
        mTvStartTime.setText(results.getStartTime()+"~");
        mTvEndTime.setText(results.getEndTime()+"/ ");
        mTvSeatCount.setText("잔여좌석:"+results.getSeatCount()+"석");
        mTvDescription.setText("·"+results.getDescription());

        if(mSingleListener!=null){
            mBtnChoose.setOnClickListener(mSingleListener);
            mIvClose.setOnClickListener(mSingleListener);
        }


    }
}
