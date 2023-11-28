package com.example.tp5.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tp5.model.Book;
import com.example.tp5.model.User;

import java.util.List;


@Dao
public interface BookDao {

    @Query("SELECT * FROM book")
    List<Book> getAll();

    @Query("SELECT COUNT(uid) FROM book")
    int getRowCount();

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);
}