package com.app.newshacker.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.newshacker.ViewModel.DetailViewModel;
import com.app.newshacker.ViewModel.HomeViewModel;
import com.app.newshacker.adapter.HomeAdapter;
import com.app.newshacker.adapter.NewsDetailsAdapter;
import com.app.newshacker.databinding.FragmentNewDetailsBinding;
import com.app.newshacker.dto.DetailResponse;
import com.app.newshacker.dto.SearchResponse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsDetailFragment extends Fragment {

    private FragmentNewDetailsBinding binding;
    private DetailViewModel detailViewModel;
    private  ProgressDialog pDialog;
    private NewsDetailsAdapter newsDetailsAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNewDetailsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initProgressDialog();
        newsDetailsAdapter = new NewsDetailsAdapter();
        detailViewModel = ViewModelProviders.of(getActivity()).get(DetailViewModel.class);
        detailViewModel.init(getArguments().getString("id"));
        observeData();
        setRecyclerView();
    }
    private void initProgressDialog(){
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
    }
    private void setRecyclerView(){
        RecyclerView recyclerView = binding.homeRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsDetailsAdapter);
    }

    private void observeData(){
        detailViewModel.getNewsResponseLiveData().observe(getActivity(), new Observer<DetailResponse.Root>() {
            @Override
            public void onChanged(@Nullable final DetailResponse.Root newName) {
                if(newName!=null) {
                    binding.points.setText(String.valueOf(newName.getPoints()));
                    binding.title.setText(newName.getTitle());
                    newsDetailsAdapter.setResults(newName.getChildren());
                }
            }
        });
        detailViewModel.getProgressLiveData().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable final Boolean newName) {
                showOrHideProgressDialog(newName);
            }
        });
    }

    private void showOrHideProgressDialog(Boolean show){
        if(show) pDialog.show(); else  pDialog.dismiss();
    }
}
