package com.app.newshacker.ViewModel;

import com.app.newshacker.dto.DetailResponse;
import com.app.newshacker.dto.SearchResponse;
import com.app.newshacker.repository.DataRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private DataRepository dataRepository;
    private MutableLiveData<DetailResponse.Root> detailResponseLiveData;

    public void init(String id) {
        dataRepository = new DataRepository();
        dataRepository.getDetails(id);
        detailResponseLiveData = dataRepository.getDetailResponseLiveData();
    }

    public LiveData<DetailResponse.Root> getNewsResponseLiveData() {
        return detailResponseLiveData;
    }

    public LiveData<Boolean> getProgressLiveData() {
        return dataRepository.getShowProgressDialog();
    }
}
