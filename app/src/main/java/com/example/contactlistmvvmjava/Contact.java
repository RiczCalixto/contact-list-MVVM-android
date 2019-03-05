package com.example.contactlistmvvmjava;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "contact")
    private String mContact;
    public Contact(@NonNull String contact) {this.mContact = contact;}
    public String getContact(){return this.mContact;}
}
