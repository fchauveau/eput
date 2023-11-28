package com.example.tp52;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.tp52.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

import kotlin.text.StringsKt;

public class MainActivity extends AppCompatActivity {

    public static final String USER_FIRST_NAME = "USER_FIRST_NAME";
    public static final String USER_LAST_NAME = "USER_LAST_NAME";
    public static final String USER_LANGS = "USER_LANGUAGES";

    private ActivityMainBinding binding;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPref = this.getSharedPreferences("preferences", Context.MODE_PRIVATE);

        binding.editMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FormMainActivity.class));
            }
        });


        binding.editLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FormLangActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataFromPreferences();
    }

    private void loadDataFromPreferences() {
        binding.firstname.setText(sharedPref.getString(USER_FIRST_NAME, "..."));
        binding.lastname.setText(sharedPref.getString(USER_LAST_NAME, "..."));

        Set<String> stringSet = sharedPref.getStringSet(USER_LANGS, new HashSet<String>());
        binding.lang.setText("");
        for (String lang : stringSet) {
            binding.lang.append(lang + ", ");
        }
    }


}