package com.example.a2023_tp4_2.dto;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class IdentityParcelable implements Parcelable {

    public String civility;
    public String firstname;
    public String lastname;
    public Integer age;
    public String address;

    public IdentityParcelable() {
    }

    protected IdentityParcelable(Parcel in) {
        civility = in.readString();
        firstname = in.readString();
        lastname = in.readString();
        if (in.readByte() == 0) {
            age = null;
        } else {
            age = in.readInt();
        }
        address = in.readString();
    }

    public static final Creator<IdentityParcelable> CREATOR = new Creator<IdentityParcelable>() {
        @Override
        public IdentityParcelable createFromParcel(Parcel in) {
            return new IdentityParcelable(in);
        }

        @Override
        public IdentityParcelable[] newArray(int size) {
            return new IdentityParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(civility);
        parcel.writeString(firstname);
        parcel.writeString(lastname);
        if (age == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(age);
        }
        parcel.writeString(address);
    }
}
