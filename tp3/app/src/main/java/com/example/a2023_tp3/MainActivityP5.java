package com.example.a2023_tp3;

import android.os.Bundle;
import com.example.a2023_tp3.databinding.ActivityMainP5Binding;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivityP5 extends AppCompatActivity {


    private ActivityMainP5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainP5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadImages();


    }

    private void loadImages() {
        Picasso.get()
                .load("https://media.istockphoto.com/id/187392278/fr/photo/lorem-ipsum-texte.jpg?s=612x612&w=0&k=20&c=JVU0F9fwWkkGV0tWkpYmVvr67PQ5KL7pDNZvL0RLrkQ=")
                .into(binding.image1);

        Picasso.get()
                .load("https://st2.depositphotos.com/2580781/8083/i/600/depositphotos_80839900-stock-photo-abstract-and-solid-color-wallpaper.jpg")
                .into(binding.image2);

        Picasso.get()
                .load("https://media.istockphoto.com/id/509636590/fr/photo/paysage-de-montagne-d%C3%A9t%C3%A9-brumeux-collines.jpg?s=612x612&w=0&k=20&c=P6avIbKkGPzBBsDuqCe-YV0H2UVAsVj9sfxrSvPL5t8=")
                .into(binding.image3);
    }
}