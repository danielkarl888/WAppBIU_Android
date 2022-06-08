package com.example.wappbiu_android;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.daos.MessageDao;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;

@Database(entities = {Contact.class, Message.class}, version = 3)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactDao contactDao();
    public abstract MessageDao messageDaoDao();
}
