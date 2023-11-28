package com.example.tp5.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tp5.model.User;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insertAll(User... users);

}