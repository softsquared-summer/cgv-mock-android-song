package com.example.mock_cgv.src.main.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.mock_cgv.src.main.login.interfaces.LogInActivityView;
import com.example.mock_cgv.src.main.login.interfaces.LogInRetrofitInterface;
import com.example.mock_cgv.src.main.login.models.LogInResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.MEDIA_TYPE_JSON;
import static com.example.mock_cgv.src.ApplicationClass.TAG;
import static com.example.mock_cgv.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;
import static com.example.mock_cgv.src.ApplicationClass.sSharedPreferences;

public class LogInService {
    private final LogInActivityView mLogInActivityView;

    LogInService(final LogInActivityView logInActivityView) {
        this.mLogInActivityView = logInActivityView;
    }

    public void getLogIn(String mUserId, String mPwd) {
        final LogInRetrofitInterface logInRetrofitInterface = getRetrofit().create(LogInRetrofitInterface.class);
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userId", mUserId);
            jsonObject.put("pw", mPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String body = jsonObject.toString();
        RequestBody requestBody = RequestBody.Companion.create(body,MEDIA_TYPE_JSON);
        logInRetrofitInterface.LogIn(requestBody).enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                LogInResponse logInResponse = response.body();
                Log.e("login",""+logInResponse.getMessage());
                mLogInActivityView.LogInSuccess(logInResponse.getMessage(),logInResponse.getResult(),logInResponse.getCode());
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                mLogInActivityView.LogInFail();
            }
        });
    }
}
