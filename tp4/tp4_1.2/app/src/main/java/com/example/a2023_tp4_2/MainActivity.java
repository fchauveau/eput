package com.example.a2023_tp4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a2023_tp4_2.databinding.ActivityMainBinding;
import com.example.a2023_tp4_2.dto.IdentityParcelable;
import com.example.a2023_tp4_2.dto.IdentitySerializable;

public class MainActivity extends AppCompatActivity {


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
                Intent intent = new Intent(currentContext, DetailsActivity.class);
                intent.putExtra(DetailsActivity.INTENT_EXTRA_IDENTITY_SERIALIZABLE, getIdentitySerializableFromForm());
                intent.putExtra(DetailsActivity.INTENT_EXTRA_IDENTITY_PARCELABLE, getIdentityParcelableFromForm());
                startActivity(intent);
            }
        });
    }

    private IdentitySerializable getIdentitySerializableFromForm() {
        IdentitySerializable result = new IdentitySerializable();
        result.civility = binding.civility.getText().toString();
        result.firstname = binding.firstname.getText().toString();
        result.lastname = binding.lastname.getText().toString();
        result.age = Integer.valueOf(binding.age.getText().toString());
        result.address = binding.address.getText().toString();
        return result;
    }

    private IdentityParcelable getIdentityParcelableFromForm() {
        IdentityParcelable result = new IdentityParcelable();
        result.civility = binding.civility.getText().toString();
        result.firstname = binding.firstname.getText().toString();
        result.lastname = binding.lastname.getText().toString();
        result.age = Integer.valueOf(binding.age.getText().toString());
        result.address = binding.address.getText().toString();
        return result;
    }
}