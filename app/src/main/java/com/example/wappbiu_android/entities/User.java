package com.example.wappbiu_android.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.wappbiu_android.ContactConvertor;
import com.example.wappbiu_android.MessageConvertor;

import java.util.List;
@Entity
public class User {
    @PrimaryKey
    @NonNull
    private String username;

    private String displayName;

    private String password;
    @TypeConverters(ContactConvertor.class)
    private List<Contact> conversations;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getConversations() {
        return conversations;
    }

    public void setConversations(List<Contact> conversations) {
        this.conversations = conversations;
    }
}
