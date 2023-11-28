package com.example.a2023_tp4_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2023_tp4_3.databinding.ActivitySelectionBinding;

public class ActivitySelection extends AppCompatActivity {

    public static final String INTENT_RESULT_COLOR = "result_color";

    private static final String ORANGE = "#FF6F00";
    private static final String GREEN = "#1B5E20";
    private static final String BLEU = "#0D47A1";

    private ActivitySelectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra(INTENT_RESULT_COLOR, getUserChoice());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private String getUserChoice() {
        if (binding.green.isChecked()) {
            return GREEN;
        }
        if (binding.orange.isChecked()) {
            return ORANGE;
        }
        if (binding.bleu.isChecked()) {
            return BLEU;
        }

        return null;
    }
}