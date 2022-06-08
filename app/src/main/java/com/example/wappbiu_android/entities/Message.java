package com.example.wappbiu_android.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.wappbiu_android.DateConverter;

import java.util.Date;

@Entity
public class Message {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String content;

    @TypeConverters(DateConverter.class)
    private Date created;

    private boolean sent;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }


}
