package com.example.a2023_tp4_1.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2023_tp4_1.databinding.ListItemViewBinding;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private List<String> data;

    public MyRecyclerViewAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemViewBinding inverted = ListItemViewBinding.inflate(LayoutInflater.from(context), parent, false);
        return new OutcomeViewHolderInverted(inverted);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String currentItem = data.get(position);

        OutcomeViewHolderInverted viewHolder = (OutcomeViewHolderInverted) holder;
        viewHolder.binding.label.setText(currentItem);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    static class OutcomeViewHolderInverted extends RecyclerView.ViewHolder {
        public ListItemViewBinding binding;

        public OutcomeViewHolderInverted(ListItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
