package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wappbiu_android.adapters.ContactListAdapter;
import com.example.wappbiu_android.adapters.MessageListAdapter;
import com.example.wappbiu_android.entities.Message;
import com.example.wappbiu_android.viewmodels.ContactsViewModel;
import com.example.wappbiu_android.viewmodels.MessageViewModelFactory;
import com.example.wappbiu_android.viewmodels.MessagesViewModel;
import com.example.wappbiu_android.viewmodels.MyViewModelFactory;
import com.example.wappbiu_android.viewmodels.RegisterViewModel;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView MessageRecycler;
    private MessageListAdapter adapter;
    private MessagesViewModel messagesViewModel;
    private String contact_name;
    private String logged_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent in = getIntent();
        contact_name = in.getExtras().getString("contact_name");
        logged_user = in.getExtras().getString("logged_user");
        TextView custom_profile_name = findViewById(R.id.custom_profile_name);
//        ImageView custom_profile_image = findViewById(R.id.custom_profile_image);
//        custom_profile_image.setImageResource(R.drawable.profileimage);
        custom_profile_name.setText(contact_name);
        List <Message> messages = new ArrayList<>();
        Object[] objects = new Object[2];
        objects[0] = logged_user;
        objects[1] = contact_name;
        messagesViewModel = new ViewModelProvider(this, new MessageViewModelFactory(getApplication(), objects)).get(MessagesViewModel.class);
        MessageRecycler = findViewById(R.id.recycler_chat);
        adapter = new MessageListAdapter(getApplicationContext());
        //adapter.setMessageList(messages);
        MessageRecycler.setAdapter(adapter);
        MessageRecycler.setLayoutManager(new LinearLayoutManager(this));

        messagesViewModel.getMessagesList().observe(this, messages1 -> {
            adapter.setMessageList(messages1);
        });

    }
}