package com.example.mock_cgv.src.main.moviedetail.review;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mock_cgv.R;
import com.example.mock_cgv.src.BaseFragment;
import com.example.mock_cgv.src.main.moviedetail.review.interfaces.ReviewFragmentView;
import com.example.mock_cgv.src.main.moviedetail.review.models.ReviewResponse;

import java.util.ArrayList;

import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class ReviewFragment extends BaseFragment implements ReviewFragmentView {

    int mMovieId,mGoldenEggRatio;
    ArrayList<ReviewData> mItems= new ArrayList<>();
    RecyclerView mRecyclerView;
    ReviewRecyclerAdapter mReviewRecyclerAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ReviewService mReviewService;

    EditText mEdtWriteContent;
    Button mBtnSendContent,mBtnLike,mBtnHate,mBtnLikeBlur,mBtnHateBlur;
    String mContent;

    String mLoginState;

    //리뷰 등록할때 전해줄 골든에그스테이트
    int mGoldenEggState=2;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_review,container,false);

        //무비디테일액티비티에서 온 번들
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mMovieId=bundle.getInt("movieid");
        }
        mReviewService = new ReviewService(this);
        mReviewService.getReview(mMovieId);

        mRecyclerView = rootView.findViewById(R.id.review_recycler);

        //새로고침
        mSwipeRefreshLayout = rootView.findViewById(R.id.review_swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                //TODO 새로고침 만들기
                //재통신을 해야된다는데 모르겟다.
                mReviewService.patchStateUpdate();

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        mBtnSendContent = rootView.findViewById(R.id.review_btn_content_send);
        mEdtWriteContent = rootView.findViewById(R.id.review_edt_content_write);

        mBtnSendContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 골든에그 고르는 버튼 만들기
                if(mLoginState!=null){ //로그인 된 상태
                    if(mGoldenEggState==2){
                        showCustomToast("좋았어요 또는 별로에요 버튼을 눌러주세요!");
                    }else{
                        mContent=mEdtWriteContent.getText().toString();
                        PostReviewContent(mContent,mMovieId,mGoldenEggRatio);
                    }
                }
                else{
                    showCustomToast("로그인 후 이용해 주세요");
                }
            }
        });
        mBtnLike=rootView.findViewById(R.id.review_btn_like);
        mBtnLikeBlur=rootView.findViewById(R.id.review_btn_like_blur);
        mBtnHateBlur=rootView.findViewById(R.id.review_btn_hate_blur);
        mBtnHate=rootView.findViewById(R.id.review_btn_hate);

        mBtnLike.setVisibility(View.VISIBLE);
        mBtnLikeBlur.setVisibility(View.INVISIBLE);
        mBtnHateBlur.setVisibility(View.INVISIBLE);
        mBtnHate.setVisibility(View.VISIBLE);


        mBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoldenEggState=1;
                mBtnLike.setVisibility(View.VISIBLE);
                mBtnLikeBlur.setVisibility(View.INVISIBLE);
                mBtnHateBlur.setVisibility(View.VISIBLE);
                mBtnHate.setVisibility(View.INVISIBLE);

                showCustomToast("좋았어요!");
            }
        });
        mBtnLikeBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoldenEggState=1;
                mBtnLike.setVisibility(View.VISIBLE);
                mBtnLikeBlur.setVisibility(View.INVISIBLE);
                mBtnHateBlur.setVisibility(View.VISIBLE);
                mBtnHate.setVisibility(View.INVISIBLE);
                showCustomToast("좋았어요!");

            }
        });
        mBtnHate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoldenEggState=0;
                mBtnLike.setVisibility(View.INVISIBLE);
                mBtnLikeBlur.setVisibility(View.VISIBLE);
                mBtnHateBlur.setVisibility(View.INVISIBLE);
                mBtnHate.setVisibility(View.VISIBLE);

                showCustomToast("별로에요!");
            }
        });
        mBtnHateBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoldenEggState=0;
                mBtnLike.setVisibility(View.INVISIBLE);
                mBtnLikeBlur.setVisibility(View.VISIBLE);
                mBtnHateBlur.setVisibility(View.INVISIBLE);
                mBtnHate.setVisibility(View.VISIBLE);

                showCustomToast("별로에요!");

            }
        });

        mLoginState=sSharedPreferences.getString(X_ACCESS_TOKEN,null);

        return rootView;
    }
    public void PostReviewContent(String content,int movieid,int goldeneggratio){
        mReviewService.postReviewEnroll(movieid,goldeneggratio,content);
    }




    @Override
    public void getReviewSucces(ReviewResponse.Result result, int code, String message) {

        if(code==100){
            int id,goldenEggStatus;
            String userId,content,DATE;
            int reviewCount = result.getReviewCount();

            for(int i=0;i<result.getReviews().size();i++){
                id=result.getReviews().get(i).getId();
                goldenEggStatus=result.getReviews().get(i).getGoldenEggStatus();
                userId=result.getReviews().get(i).getUserId();
                content=result.getReviews().get(i).getContent();
                DATE=result.getReviews().get(i).getDATE();
                ReviewData reviewData = new ReviewData(id,userId,goldenEggStatus,content,DATE);
                mItems.add(reviewData);
            }
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            ReviewRecyclerAdapter mReviewRecyclerAdapter = new ReviewRecyclerAdapter(mItems,reviewCount);
            mRecyclerView.setAdapter(mReviewRecyclerAdapter);

            TextView TvReviewCount = rootView.findViewById(R.id.review_tv_review_count);
            String ReviewCountString = String.valueOf(reviewCount);
            TvReviewCount.setText(ReviewCountString+"건");
        }


    }

    @Override
    public void getReviewFail() {

    }

    @Override
    public void patchStateUpdateSuccess(String message) {
        Log.e("patch success(API 12번)" ,"Message: "+message);
    }

    @Override
    public void patchStateUpdateFail() {

    }

    @Override
    public void postReviewEnrollSuccess(String message) {
        showCustomToast(message);
    }

    @Override
    public void postReviewEnrollFail() {

    }
}
