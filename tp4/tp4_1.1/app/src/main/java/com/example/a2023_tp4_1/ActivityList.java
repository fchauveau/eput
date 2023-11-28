package com.example.a2023_tp4_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2023_tp4_1.databinding.ActivityListBinding;
import com.example.a2023_tp4_1.recyclerview.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity {
    public static final String MAX_ITEMS = "MAX_ITEMS";
    private com.example.a2023_tp4_1.databinding.ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int maxItems = getIntent().getIntExtra(MAX_ITEMS, 200);
        initRecyclerView(maxItems);
    }

    private void initRecyclerView(int maxItems) {
        List<String> data = generateList(maxItems);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, data);
        binding.recyclerview.setAdapter(adapter);
    }

    private List<String> generateList(int max) {
        List<String> out = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            out.add("Élément #" + i);
        }
        return out;
    }
}