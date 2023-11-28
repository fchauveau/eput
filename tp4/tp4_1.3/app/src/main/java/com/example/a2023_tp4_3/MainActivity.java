package com.example.a2023_tp4_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.a2023_tp4_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final int SELECT_COLOR_REQUEST_CODE = 10;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Context currentContext = this;
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentContext, ActivitySelection.class);
                startActivityForResult(intent, SELECT_COLOR_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_COLOR_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String color = data.getStringExtra(ActivitySelection.INTENT_RESULT_COLOR);
                binding.icon.setColorFilter(Color.parseColor(color));
            }
        }
    }
}