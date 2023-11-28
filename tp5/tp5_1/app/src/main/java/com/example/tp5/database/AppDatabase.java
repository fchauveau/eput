package com.example.tp5.database;

import androidx.room.Database;

import androidx.room.RoomDatabase;

import com.example.tp5.model.Book;
import com.example.tp5.model.User;


@Database(entities = {User.class, Book.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract BookDao bookDao();

}