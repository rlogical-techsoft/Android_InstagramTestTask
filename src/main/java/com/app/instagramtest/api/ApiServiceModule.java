package com.app.instagramtest.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceModule {

    private static final String API_ENDPOINT = "https://api.instagram.com/v1/";

    private static OkHttpClient.Builder okHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    private static OkHttpClient.Builder okHttpClientTokenHeader(final String token) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .build();
                return chain.proceed(newRequest);
            }
        });
        return okHttpClient;
    }

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_ENDPOINT).addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(okHttpClient().build()).build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createTokenizedService(Class<S> serviceClass, String token) {
        Retrofit retrofit = builder.client(okHttpClientTokenHeader(token).build()).build();
        return retrofit.create(serviceClass);
    }


}
