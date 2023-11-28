package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.example.tp5.database.AppDatabase;
import com.example.tp5.databinding.ActivityBookFormBinding;
import com.example.tp5.model.Book;

public class BookFormActivity extends AppCompatActivity {
    public static final String INTENT_EXTRA_BOOK_TO_EDIT = "BOOK_TO_EDIT";

    private ActivityBookFormBinding binding;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();


        Book bookToEdit = getIntent().getParcelableExtra(INTENT_EXTRA_BOOK_TO_EDIT, Book.class);
        if (bookToEdit == null) {

            binding.save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveNewBook();
                }
            });
        } else {
            binding.title.setText(bookToEdit.title);
            binding.author.setText(bookToEdit.author);
            binding.editor.setText(bookToEdit.editor);
            binding.save.setText("Mettre à jour");

            binding.save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateBook(bookToEdit);
                }
            });
        }
    }

    private void updateBook(Book bookToEdit) {
        bookToEdit.title = binding.title.getText().toString();
        bookToEdit.author = binding.author.getText().toString();
        bookToEdit.editor = binding.editor.getText().toString();

        database.getQueryExecutor().execute(() -> {
            database.bookDao().update(bookToEdit);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            });
        });

    }

    private void saveNewBook() {
        Book bookToSave = new Book();
        bookToSave.title = binding.title.getText().toString();
        bookToSave.author = binding.author.getText().toString();
        bookToSave.editor = binding.editor.getText().toString();
        bookToSave.page = 465;
        bookToSave.year = "2000";

        database.getQueryExecutor().execute(() -> {
            database.bookDao().insert(bookToSave);


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            });
        });
    }
}