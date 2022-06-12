package com.example.wappbiu_android.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;

import java.util.List;

@Dao
public interface ContactDao  {
    //get a certain contact
    @Query("SELECT * FROM contact where id = :id" )
    Contact get(String id);
    // get all contacts
    @Query("SELECT * FROM contact" )
    List<Contact> index();

//     //get messages from a certain contact
//    @Query("SELECT messages FROM contact where id = :id" )
//    List<Message> getMessages(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Contact... contacts);

    @Update
    void update (Contact... contacts);

    @Delete
    void delete (Contact... contacts);

}
