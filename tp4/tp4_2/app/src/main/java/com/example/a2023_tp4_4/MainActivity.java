package com.example.a2023_tp4_4;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.a2023_tp4_4.databinding.ActivityMainBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        setOrRefreshPermissionStatuses();
        binding.locationRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
            }
        });
        binding.locationTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLastLocation();
            }
        });
        binding.cameraRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA);
            }
        });
        binding.cameraTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
            }
        });
    }

    private void setOrRefreshPermissionStatuses() {
        binding.locationStatus.setText(getPermissionStatus(Manifest.permission.ACCESS_FINE_LOCATION));
        binding.cameraStatus.setText(getPermissionStatus(Manifest.permission.CAMERA));
    }

    private String getPermissionStatus(String permission) {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            return "Status : True";
        } else {
            return "Status : False";
        }
    }


    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
        setOrRefreshPermissionStatuses();
    });

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        String message = "";
                        if (location != null) {
                            message = "Latitude=" + location.getLatitude() + "\nLongitude=" + location.getLongitude();
                        }
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Coordonées GPS")
                                .setMessage(message)
                                .setPositiveButton("OK", null)
                                .create()
                                .show();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Coordonées GPS")
                                .setMessage("No location")
                                .setPositiveButton("OK", null)
                                .create()
                                .show();
                    }
                });
    }
}