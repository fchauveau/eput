package com.example.tp52;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.tp52.databinding.ActivityLangFormBinding;

import java.util.HashSet;
import java.util.Set;

public class FormLangActivity extends AppCompatActivity {

    private ActivityLangFormBinding binding;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLangFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sharedPref = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<String> langs = getSelectedLangs();
                sharedPref.edit()
                        .putStringSet(MainActivity.USER_LANGS, langs)
                        .commit();

                finish();
            }
        });
    }

    @NonNull
    private Set<String> getSelectedLangs() {
        Set<String> langs = new HashSet<>();
        if (binding.langJava.isChecked()) {
            langs.add("JAVA");
        }
        if (binding.langPython.isChecked()) {
            langs.add("Python");
        }
        if (binding.langRust.isChecked()) {
            langs.add("Rust");
        }
        return langs;
    }
}