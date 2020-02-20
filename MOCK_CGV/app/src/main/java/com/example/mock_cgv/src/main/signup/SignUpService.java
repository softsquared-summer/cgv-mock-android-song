package com.example.mock_cgv.src.main.signup;

import com.example.mock_cgv.src.main.interfaces.MainActivityView;
import com.example.mock_cgv.src.main.interfaces.MainRetrofitInterface;
import com.example.mock_cgv.src.main.models.DefaultResponse;
import com.example.mock_cgv.src.main.signup.interfaces.SignUpActivityView;
import com.example.mock_cgv.src.main.signup.interfaces.SignUpRetrofitInterface;
import com.example.mock_cgv.src.main.signup.models.SignUpResponse;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mock_cgv.src.ApplicationClass.getRetrofit;

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
        final String body = jsonObject.toString();
        signUpRetrofitInterface.SignUp(body).enqueue(new Callback<SignUpResponse>() {
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



//    void getTest(){
//        final SignUpRetrofitInterface signUpRetrofitInterface = getRetrofit().create(SignUpRetrofitInterface.class);
//        signUpRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
//            @Override
//            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//                final DefaultResponse defaultResponse = response.body();
//                //defaultResponse의 바디를 가져오면
//                if(defaultResponse == null){
//                    mSignUpActivityView.validateFailure(null);
//                    return;
//                }
//                //그 바디의 코드를 가져다 쓸 수 있는것 그 코드가 int였으니까 int값인거임
//                if(defaultResponse.getCode()==200){
//                    mSignUpActivityView.validateSuccess(defaultResponse.getMessage());
//                }
//                mSignUpActivityView.validateSuccess(defaultResponse.getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResponse> call, Throwable t) {
//                mSignUpActivityView.validateFailure(null);
//            }
//        });
//    }
