package com.example.mock_cgv.src.main.numberselect;

import com.example.mock_cgv.src.main.numberselect.interfaces.NumberSelcetRetrofitInterface;
import com.example.mock_cgv.src.main.numberselect.interfaces.NumberSelectActivityView;
import com.example.mock_cgv.src.main.numberselect.models.NumberSelectResponse;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

public class NumberSelectService {

    private final NumberSelectActivityView mNumberSelectActivityView;


    public NumberSelectService(NumberSelectActivityView mNumberSelectActivityView) {
        this.mNumberSelectActivityView = mNumberSelectActivityView;
    }

    public void postBuyTicket(int movieTimeId,int countAdult,int countStudent,int countSpecial){
        final NumberSelcetRetrofitInterface numberSelcetRetrofitInterface = getRetrofit().create(NumberSelcetRetrofitInterface.class);

        final JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("countAdult",countAdult);
            jsonObject.put("countStudent",countStudent);
            jsonObject.put("countSpecial",countSpecial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String body = jsonObject.toString();
        RequestBody requestBody= RequestBody.Companion.create(body,MEDIA_TYPE_JSON);

        numberSelcetRetrofitInterface.postBuy(requestBody,movieTimeId).enqueue(new Callback<NumberSelectResponse>() {
            @Override
            public void onResponse(Call<NumberSelectResponse> call, Response<NumberSelectResponse> response) {
                NumberSelectResponse numberSelectResponse = response.body();
                mNumberSelectActivityView.postBuyTicketSuccess(numberSelectResponse.getResult());

            }

            @Override
            public void onFailure(Call<NumberSelectResponse> call, Throwable t) {

            }
        });
    }
}
