package com.newgate.ecotransandroid.base;

import android.content.Context;

import com.newgate.ecotransandroid.utils.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private Context context;

    private static ApiClient instance;

    public static ApiClient getInstance(Context context) {
        if(instance == null) {
            instance =  new ApiClient(context);
        }
        return instance;
    }

    public ApiClient(Context context) {
        this.context = context;
    }

    public Retrofit getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL_PRODUCTION)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getRequestHeader())
                .build();
        return retrofit;
    }

    public OkHttpClient getRequestHeader() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(150, TimeUnit.SECONDS)
                .readTimeout(150, TimeUnit.SECONDS)
                .addInterceptor(interceptor);
        return okHttpClient.build();
    }

}