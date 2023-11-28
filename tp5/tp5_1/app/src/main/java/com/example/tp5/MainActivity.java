package com.example.tp5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.tp5.database.AppDatabase;
import com.example.tp5.databinding.ActivityMainBinding;
import com.example.tp5.model.Book;
import com.example.tp5.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();

        insertDefaultData();
        initRecyclerView();
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BookFormActivity.class));
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        refreshBookList();
    }

    private void refreshBookList() {
        database.getQueryExecutor().execute(() -> {
            List<Book> allbooks = database.bookDao().getAll();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((BookRecyclerViewAdapter) binding.recyclerview.getAdapter()).updateBookList(allbooks);
                }
            });
        });
    }

    private void initRecyclerView() {
        BookRecyclerViewAdapter adapter = new BookRecyclerViewAdapter(this, new ArrayList<>());
        binding.recyclerview.setAdapter(adapter);
    }


    private void insertDefaultData() {
        database.getQueryExecutor().execute(() -> {
            if (database.bookDao().getRowCount() == 0) {
                database.bookDao().insert(new Book("Book Title A", "Jean Pierre", "SF", "Editor", "1980", 500));
                database.bookDao().insert(new Book("Book Title B", "Jean Paul", "SF", "Editor", "1980", 500));
                database.bookDao().insert(new Book("Book Title C", "Jean Jacques", "SF", "Editor", "1980", 500));
            }
        });
    }
}