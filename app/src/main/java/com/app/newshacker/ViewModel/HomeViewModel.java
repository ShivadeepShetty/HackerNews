package com.app.newshacker.ViewModel;

import android.app.Application;

import com.app.newshacker.dto.SearchResponse;
import com.app.newshacker.repository.DataRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private DataRepository dataRepository;
    private MutableLiveData<SearchResponse.Root> searchResponseLiveData;


    public void init() {
        dataRepository = new DataRepository();
        dataRepository.searchNews("test");
        searchResponseLiveData = dataRepository.getNewsResponseLiveData();
    }

    public void searchData(String data){
        dataRepository.searchNews(data);
    }



    public LiveData<SearchResponse.Root> getVolumesResponseLiveData() {
        return searchResponseLiveData;
    }

    public LiveData<Boolean> getProgressLiveData() {
        return dataRepository.getShowProgressDialog();
    }
}
