package com.example.mock_cgv.src.main;

import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.interfaces.MainRetrofitInterface;
import com.example.mock_cgv.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

class MainService {
    private final MainActivityView mMainActivityView;

    //생성자
    MainService(final MainActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void getTest(){
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                //defaultResponse의 바디를 가져오면
                if(defaultResponse == null){
                    mMainActivityView.validateFailure(null);
                    return;
                }
                //그 바디의 코드를 가져다 쓸 수 있는것 그 코드가 int였으니까 int값인거임
                if(defaultResponse.getCode()==200){
                    mMainActivityView.validateSuccess(defaultResponse.getMessage());
                }else if(defaultResponse.getCode()==201){
                    mMainActivityView.validateSuccess201(defaultResponse.getMessage());
                }
                mMainActivityView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
            }
        });
    }
}
