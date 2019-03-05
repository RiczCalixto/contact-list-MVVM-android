package com.example.contactlistmvvmjava;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ContactDao {

    @Query("SELECT * from contact_table ORDER BY contact ASC")
    LiveData<List<Contact>> getAllContacts();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Contact word);

    @Query("DELETE FROM contact_table")
    void deleteAll();
}
