package com.example.wappbiu_android.entities;

import java.util.List;

public class User {

    private String username;

    private String displayName;

    private String password;

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
