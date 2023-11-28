package com.example.tp5.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {

    @PrimaryKey
    public int uid;
    @ColumnInfo(name = "first_name")
    public String firstName;


    public User() {
    }
}