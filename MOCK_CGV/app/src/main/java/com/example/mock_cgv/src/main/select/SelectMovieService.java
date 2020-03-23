package com.example.mock_cgv.src.main.select;

import com.example.mock_cgv.src.main.select.interfaces.SelectMovieActivityView;
import com.example.mock_cgv.src.main.select.interfaces.SelectMovieRetrofitInterface;
import com.example.mock_cgv.src.main.select.models.SelectMovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class SelectMovieService {

    public final SelectMovieActivityView selectMovieActivityView;

    public SelectMovieService(SelectMovieActivityView selectMovieActivityView) {
        this.selectMovieActivityView = selectMovieActivityView;
    }

    public void getMovieSelect(){
        final SelectMovieRetrofitInterface selectMovieRetrofitInterface = getRetrofit().create(SelectMovieRetrofitInterface.class);
        selectMovieRetrofitInterface.getMovieList().enqueue(new Callback<SelectMovieResponse>() {
            @Override
            public void onResponse(Call<SelectMovieResponse> call, Response<SelectMovieResponse> response) {
                SelectMovieResponse selectMovieResponse = response.body();
                selectMovieActivityView.getMovieListSuccess(selectMovieResponse.getResult());
            }

            @Override
            public void onFailure(Call<SelectMovieResponse> call, Throwable t) {

            }
        });



    }


}
