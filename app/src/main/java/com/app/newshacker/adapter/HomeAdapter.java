package com.app.newshacker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.newshacker.R;
import com.app.newshacker.dto.SearchResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.NewsResultHolder> {

    private List<SearchResponse.Hits> results = new ArrayList<>();
    private RecyclerItemOnclickListener recyclerItemOnclickListener;

    @NonNull
    @Override
    public NewsResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new NewsResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsResultHolder holder, int position) {
        holder.authorsTextView.setText(results.get(position).getAuthor());
        holder.titleTextView.setText(results.get(position).getTitle());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerItemOnclickListener.onItemClick(results.get(position).getObjectID());
            }
        });
    }

    public  void  setResults(List<SearchResponse.Hits> results){
        this.results = results;
        notifyDataSetChanged();
    }

    public void setListener(RecyclerItemOnclickListener recyclerItemOnclickListener){
        this.recyclerItemOnclickListener = recyclerItemOnclickListener;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class NewsResultHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView authorsTextView;
        private ConstraintLayout layout;

        public NewsResultHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            authorsTextView = itemView.findViewById(R.id.author);
            layout = itemView.findViewById(R.id.layout);

        }
    }

    public interface  RecyclerItemOnclickListener{
          void onItemClick(String id);
    }
}
