package com.example.mock_cgv.src;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.mock_cgv.config.XAccessTokenInterceptor;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationClass extends Application {
    public static MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=uft-8");
    public static MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");

    //테스트 서버 주소
    public static String TEST_URL = "https://test.winonesong.me";

    //실서버 주소
   //public static String BASE_URL = "https://winonesong.me";
    public static String BASE_URL = "http://winonesong.me/";

    public static SharedPreferences sSharedPreferences = null;

    //SharedPreferences 키 값
    public static String TAG = "TEMPLATE_APP";

    //JWT Token 값
    public static String X_ACCESS_TOKEN = "X-ACCESS-TOKEN";

    //날짜 형식
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

    // Retrofit 인스턴스
    public static Retrofit retrofit;


    @Override
    public void onCreate() {
        super.onCreate();

        if(sSharedPreferences==null){
            sSharedPreferences = getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
    }


    public static Retrofit getRetrofit(){
        if(retrofit == null){
            OkHttpClient client = new OkHttpClient.Builder() //OkHttpClient객체 생성
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .connectTimeout(5000,TimeUnit.MILLISECONDS)
                    //세션데이터 삽입을 위해 XAccessTokenInterceptor추가
                    .addNetworkInterceptor(new XAccessTokenInterceptor())
                    .build();

            retrofit = new Retrofit.Builder() //객체생성
                    .baseUrl(BASE_URL)
                    //위에서 만든 client객체를 추가
                    .client(client)
                    //json 형식의 response 데이터의 파싱을 위해 Gson 추가
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
