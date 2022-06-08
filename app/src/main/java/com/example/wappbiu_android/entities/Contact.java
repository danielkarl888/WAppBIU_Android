package com.example.wappbiu_android.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.wappbiu_android.DateConverter;
import com.example.wappbiu_android.MessageConvertor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Contact {
    @PrimaryKey
    @NonNull
    private String id;

    private String name;

    private String server;

    private String last;

    @TypeConverters(DateConverter.class)
    private Date LastDate;

    @TypeConverters(MessageConvertor.class)
    private List<Message> messages;

    public Contact() {
    }

    public Contact(@NonNull String id, String name, String server) {
        this.id = id;
        this.name = name;
        this.server = server;
    }

    public Contact(String name, String last, Date lastDate) {
        this.name = name;
        this.last = last;
        LastDate = lastDate;
        this.server = "localhost:5000";
        this.id = "daniel";
        this.messages = new LinkedList<>();
        this.messages.add(new Message());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Date getLastDate() {
        return LastDate;
    }

    public void setLastDate(Date lastDate) {
        LastDate = lastDate;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
