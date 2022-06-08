package com.example.wappbiu_android.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;

import java.util.List;

@Dao
public interface MessageDao {
    // get a certain message
    @Query("SELECT * FROM message where id = :id" )
    Message get(String id);

    @Query("SELECT * FROM message" )
    List<Message> index();

    @Insert
    void insertMessage(Message... messages);

    @Update
    void update (Message... messages);

    @Delete
    void delete (Message... messages);



}

