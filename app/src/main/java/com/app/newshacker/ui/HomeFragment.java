package com.app.newshacker.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.newshacker.R;
import com.app.newshacker.ViewModel.HomeViewModel;
import com.app.newshacker.adapter.HomeAdapter;
import com.app.newshacker.databinding.FragmentHomeBinding;
import com.app.newshacker.dto.SearchResponse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment implements HomeAdapter.RecyclerItemOnclickListener {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter = new HomeAdapter();
    private  ProgressDialog pDialog;
    private  ActivityListener activityListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initProgressDialog();
        homeAdapter = new HomeAdapter();
        homeAdapter.setListener(this);
        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        homeViewModel.init();
        observeData();
        setRecyclerView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void observeData(){
        homeViewModel.getVolumesResponseLiveData().observe(getActivity(), new Observer<SearchResponse.Root>() {
            @Override
            public void onChanged(@Nullable final SearchResponse.Root newName) {
                  homeAdapter.setResults(newName.getHits());
            }
        });
        homeViewModel.getProgressLiveData().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable final Boolean newName) {
                 showOrHideProgressDialog(newName);
            }
        });
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = binding.homeRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(homeAdapter);
    }

    private void initProgressDialog(){
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
    }


    private void showOrHideProgressDialog(Boolean show){
        if(show) pDialog.show(); else  pDialog.dismiss();
    }

    @Override
    public void onItemClick(String id) {
        if(activityListener!=null){
            activityListener.loadItem(id);
        }
    }

    public void onItemSearched(String item){
        homeViewModel.searchData(item);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        activityListener = (ActivityListener) activity;
    }

    public interface  ActivityListener{

        void loadItem(String id);
    }
}



