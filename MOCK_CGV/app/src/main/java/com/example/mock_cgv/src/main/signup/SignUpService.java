package com.example.mock_cgv.src.main.signup;

import android.util.Log;

import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.interfaces.MainRetrofitInterface;
import com.example.mock_cgv.src.main.models.DefaultResponse;
import com.example.mock_cgv.src.main.signup.interfaces.SignUpActivityView;
import com.example.mock_cgv.src.main.signup.interfaces.SignUpRetrofitInterface;
import com.example.mock_cgv.src.main.signup.models.SignUpResponse;

import org.json.JSONObject;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;
import static com.example.mock_cgv.src.ApplicationClass.retrofit;

public class SignUpService {
    private final SignUpActivityView mSignUpActivityView;

    //생성자
    SignUpService(final SignUpActivityView signUpActivityView) {
        this.mSignUpActivityView = signUpActivityView;
    }
    void getSignUp(String userId,String pw,String email,String userName,int sexStatus,int ageStatus){
        final SignUpRetrofitInterface signUpRetrofitInterface = getRetrofit().create(SignUpRetrofitInterface.class);
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("userId",userId);
            jsonObject.put("pw",pw);
            jsonObject.put("email",email);
            jsonObject.put("userName",userName);
            jsonObject.put("sexStatus",sexStatus);
            jsonObject.put("ageStatus",ageStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("json","생성한 json: "+jsonObject.toString());
        String body = jsonObject.toString();
        RequestBody requestBody = RequestBody.Companion.create(body, MEDIA_TYPE_JSON);
        signUpRetrofitInterface.SignUp(requestBody).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                SignUpResponse signUpResponse = response.body();
                mSignUpActivityView.SignUpSuccess(signUpResponse.getMessage());
                }
            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                mSignUpActivityView.SignUpFail();
            }
        });
    }
}


