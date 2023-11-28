package com.example.tp52;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.tp52.databinding.ActivityFormBinding;

public class FormMainActivity extends AppCompatActivity {

    private ActivityFormBinding binding;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPref = getSharedPreferences("preferences", Context.MODE_PRIVATE);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPref.edit()
                        .putString(MainActivity.USER_FIRST_NAME, binding.firstname.getText().toString())
                        .putString(MainActivity.USER_LAST_NAME, binding.lastname.getText().toString())
                        .commit();

                finish();
            }
        });
    }
}