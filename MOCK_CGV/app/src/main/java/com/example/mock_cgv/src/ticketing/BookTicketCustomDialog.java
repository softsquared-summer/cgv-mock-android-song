package com.example.mock_cgv.src.ticketing;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mock_cgv.R;

public class BookTicketCustomDialog extends Dialog {

    private View.OnClickListener mLeftListenr;
    private View.OnClickListener mRightListenr;
    private View.OnClickListener mCheckListenr;
    private Context mContext;
    private int mStundentCount,mAdultCount,mSpecialCount;
    public BookTicketCustomDialog(@NonNull Context context, View.OnClickListener leftListenr,View.OnClickListener rightListenr,
                                  View.OnClickListener checkListener,int adultCount,int stundentCount,int specialCount) {
        super(context);
        this.mContext=context;
        this.mLeftListenr=leftListenr;
        this.mRightListenr=rightListenr;
        this.mCheckListenr=checkListener;
        this.mAdultCount=adultCount;
        this.mStundentCount=stundentCount;
        this.mSpecialCount=specialCount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams IpWindow = new WindowManager.LayoutParams();
        IpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        IpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(IpWindow);

        setContentView(R.layout.custom_dialog_book_ticket);

        TextView TvCountAdult, TvCountStudent, TvCountSpecial;
        Button BtnBuy,BtnExit,TvCountAdultMinus,TvCountAdultPlus,TvCountStudentMinus,TvCountStudentPlus,TvCountSpecialMinus,TvCountSpecialPlus;
        TvCountAdult=findViewById(R.id.book_dialog_countAdult);
        TvCountAdultMinus=findViewById(R.id.book_dialog_countAdult_minus);
        TvCountAdultPlus=findViewById(R.id.book_dialog_countAdult_plus);

        TvCountSpecial=findViewById(R.id.book_dialog_countSpecial);
        TvCountSpecialMinus=findViewById(R.id.book_dialog_countSpecial_minus);
        TvCountSpecialPlus =findViewById(R.id.book_dialog_countSpecial_plus);

        TvCountStudent=findViewById(R.id.book_dialog_countStudent);
        TvCountStudentMinus=findViewById(R.id.book_dialog_countStudent_minus);
        TvCountStudentPlus=findViewById(R.id.book_dialog_countStudent_plus);

        BtnBuy=findViewById(R.id.book_dialog_buy);
        BtnExit=findViewById(R.id.book_dialog_exit);

        String adult=Integer.toString(mAdultCount);
        String student=Integer.toString(mSpecialCount);
        String special=Integer.toString(mStundentCount);

        TvCountAdult.setText(adult);
        TvCountSpecial.setText(student);
        TvCountStudent.setText(special);

        if(mLeftListenr!=null){
            BtnBuy.setOnClickListener(mLeftListenr);
        }
        if(mRightListenr!=null){
            BtnExit.setOnClickListener(mRightListenr);
        }
        if(mCheckListenr!=null){
            TvCountAdultMinus.setOnClickListener(mCheckListenr);
            TvCountAdultPlus.setOnClickListener(mCheckListenr);

            TvCountSpecialMinus.setOnClickListener(mCheckListenr);
            TvCountSpecialPlus.setOnClickListener(mCheckListenr);

            TvCountStudentMinus.setOnClickListener(mCheckListenr);
            TvCountStudentPlus.setOnClickListener(mCheckListenr);
        }

    }
}
