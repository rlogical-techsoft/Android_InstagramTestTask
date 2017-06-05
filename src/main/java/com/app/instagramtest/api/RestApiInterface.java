package com.app.instagramtest.api;

import com.app.instagramtest.api.response.RecentResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApiInterface {

    @GET("users/self/media/recent")
    Call<RecentResponse> updateProfile(@Query("max_id") int max, @Query("access_token") String accessToken);

}
