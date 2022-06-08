package com.example.wappbiu_android.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wappbiu_android.entities.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM contact where id = :id" )
    Contact get(int id);

    @Query("SELECT * FROM contact" )
    List<Contact> index();

    @Insert
    void insert (Contact... contacts);

    @Update
    void update (Contact... contacts);

    @Delete
    void delete (Contact... contacts);


}
