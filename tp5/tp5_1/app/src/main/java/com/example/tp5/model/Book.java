package com.example.tp5.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "author")
    public String author;
    @ColumnInfo(name = "category")
    public String category;
    @ColumnInfo(name = "editor")
    public String editor;
    @ColumnInfo(name = "year")
    public String year;
    @ColumnInfo(name = "pages")
    public Integer page;

    public Book() {
    }

    public Book(String title, String author, String category, String editor, String year, Integer page) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.editor = editor;
        this.year = year;
        this.page = page;
    }

    protected Book(Parcel in) {
        uid = in.readInt();
        title = in.readString();
        author = in.readString();
        category = in.readString();
        editor = in.readString();
        year = in.readString();
        if (in.readByte() == 0) {
            page = null;
        } else {
            page = in.readInt();
        }
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(uid);
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(category);
        parcel.writeString(editor);
        parcel.writeString(year);
        if (page == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(page);
        }
    }
}
