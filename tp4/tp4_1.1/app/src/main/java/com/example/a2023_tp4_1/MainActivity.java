package com.example.a2023_tp4_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a2023_tp4_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Context currentContext = this;
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentContext, ActivityList.class);
                Integer value = getInputValue(binding);
                intent.putExtra(ActivityList.MAX_ITEMS, value);
                startActivity(intent);
            }
        });
    }

    @NonNull
    private static Integer getInputValue(ActivityMainBinding binding) {
        try {
            String inputAsString = binding.input.getText().toString();
            return Integer.valueOf(inputAsString);
        } catch (Exception e) {
            // Failed to parse input as Integer
            return null;
        }
    }
}