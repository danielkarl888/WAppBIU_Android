package com.example.wappbiu_android.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;
import com.example.wappbiu_android.entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user where username = :username" )
    User get(String username);

//    @Query("SELECT conversations FROM user where username = :username" )
//    List<Contact> getConversations(String username);

    @Query("SELECT displayName FROM user where username = :username" )
    String getDisplayName(String username);

    @Query("SELECT password FROM user where username = :username" )
    String getPassword(String username);
    //get messages from a certain contact

//    @Query("SELECT messages FROM contact join user where id = :id and username = :username " )
//    List<Message> getMessages(String id, String username);


    @Query("SELECT * FROM user")
    List<User> index();

    @Insert
    void insertUser (User... users);

    @Update
    void update (User... users);

    @Delete
    void delete (User... users);

}
