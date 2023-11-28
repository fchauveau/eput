package com.example.a2023_tp4_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2023_tp4_2.databinding.ActivityDetailsBinding;
import com.example.a2023_tp4_2.dto.IdentityParcelable;
import com.example.a2023_tp4_2.dto.IdentitySerializable;

public class DetailsActivity extends AppCompatActivity {
    public static final String INTENT_EXTRA_IDENTITY_SERIALIZABLE = "identity_serializable";
    public static final String INTENT_EXTRA_IDENTITY_PARCELABLE = "identity_parcelable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailsBinding binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        IdentitySerializable identity = getIntent().getSerializableExtra(INTENT_EXTRA_IDENTITY_SERIALIZABLE, IdentitySerializable.class);
//        IdentityParcelable identity = getIntent().getParcelableExtra(INTENT_EXTRA_IDENTITY_PARCELABLE, IdentityParcelable.class);

        binding.civility.setText(identity.civility);
        binding.firstname.setText(identity.firstname);
        binding.lastname.setText(identity.lastname);
        binding.age.setText(identity.age.toString());
        binding.address.setText(identity.address);
    }
}