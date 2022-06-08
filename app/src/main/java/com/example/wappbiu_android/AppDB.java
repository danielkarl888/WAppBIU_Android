package com.example.wappbiu_android;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.daos.MessageDao;
import com.example.wappbiu_android.daos.UserDao;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;
import com.example.wappbiu_android.entities.User;

@Database(
        version = 1,
        entities = {Contact.class, Message.class , User.class}
)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactDao contactDao();
    public abstract MessageDao messageDao();
    public abstract UserDao userDao();
}
