package com.app.newshacker.repository;

import com.app.newshacker.apis.SearchNewsService;
import com.app.newshacker.dto.DetailResponse;
import com.app.newshacker.dto.SearchResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRepository {
    private static final String NEWS_SEARCH_SERVICE_BASE_URL = "https://hn.algolia.com/api/v1/";

    private SearchNewsService newsSearchService;
    private MutableLiveData<SearchResponse.Root> newsResponseLiveData;
    private MutableLiveData<DetailResponse.Root> detailResponseLiveData;
    private MutableLiveData<Boolean> showProgressDialog;

    public DataRepository() {
        newsResponseLiveData = new MutableLiveData<>();
        detailResponseLiveData = new MutableLiveData<>();
        showProgressDialog = new MutableLiveData<>();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        newsSearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(NEWS_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SearchNewsService.class);

    }

    public void searchNews(String query) {
        showProgressDialog.postValue(true);
        newsSearchService.searchNews(query)
                .enqueue(new Callback<SearchResponse.Root>() {
                    @Override
                    public void onResponse(Call<SearchResponse.Root> call, Response<SearchResponse.Root> response) {
                        showProgressDialog.postValue(false);
                        if (response.body() != null) {
                            newsResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchResponse.Root> call, Throwable t) {
                        showProgressDialog.postValue(false);
                        newsResponseLiveData.postValue(null);
                    }
                });
    }
    public void getDetails(String id) {
        showProgressDialog.postValue(true);
        String url = NEWS_SEARCH_SERVICE_BASE_URL + "items/" + id;
        newsSearchService.getDetails(url)
                .enqueue(new Callback<DetailResponse.Root>() {
                    @Override
                    public void onResponse(Call<DetailResponse.Root> call, Response<DetailResponse.Root> response) {
                        showProgressDialog.postValue(false);
                        if (response.body() != null) {
                            detailResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<DetailResponse.Root> call, Throwable t) {
                        showProgressDialog.postValue(false);
                        detailResponseLiveData.postValue(null);
                    }
                });
    }

    public MutableLiveData<SearchResponse.Root> getNewsResponseLiveData() {
        return newsResponseLiveData;
    }
    public MutableLiveData<DetailResponse.Root> getDetailResponseLiveData() {
        return detailResponseLiveData;
    }
    public MutableLiveData<Boolean> getShowProgressDialog() {
        return showProgressDialog;
    }
}
