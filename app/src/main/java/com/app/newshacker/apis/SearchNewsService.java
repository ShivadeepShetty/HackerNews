package com.app.newshacker.apis;

import com.app.newshacker.dto.DetailResponse;
import com.app.newshacker.dto.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface SearchNewsService {

    @GET("search")
    Call<SearchResponse.Root> searchNews(@Query("query") String query);

    @GET
    Call<DetailResponse.Root> getDetails(@Url String url);
}
