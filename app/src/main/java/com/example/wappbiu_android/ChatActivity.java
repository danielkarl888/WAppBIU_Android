package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.wappbiu_android.adapters.ContactListAdapter;
import com.example.wappbiu_android.adapters.MessageListAdapter;
import com.example.wappbiu_android.entities.Message;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
   // private RecyclerView MessageRecycler;
    //private MessageListAdapter MessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Date date = new Date();
        ArrayList <Message> messages = new ArrayList<>();
        messages.add(new Message(1,"hi",date,true));
        messages.add(new Message(2,"bye",date,true));
        messages.add(new Message(3,"foooo",date,true));
        messages.add(new Message(4,"bar",date,false));
        messages.add(new Message(5,"hi",date,true));
        messages.add(new Message(6,"bye",date,true));
        messages.add(new Message(7,"foooo",date,true));
        messages.add(new Message(8,"bar",date,true));
        messages.add(new Message(9,"hi",date,false));
        messages.add(new Message(10,"bye",date,true));
        messages.add(new Message(11,"foooo",date,true));
        messages.add(new Message(12,"bar",date,true));
        RecyclerView MessageRecycler = findViewById(R.id.recycler_chat);
        final MessageListAdapter adapter = new MessageListAdapter(this, messages);
        MessageRecycler.setAdapter(adapter);
        MessageRecycler.setLayoutManager(new LinearLayoutManager(this));

    }
}