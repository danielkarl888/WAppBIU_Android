package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wappbiu_android.adapters.ContactListAdapter;
import com.example.wappbiu_android.entities.Contact;

import java.util.ArrayList;
import java.util.Date;

public class ContactsActivity extends AppCompatActivity {
    final private String[] userNames = {
            "Blue User", "Golden User", "Green User", "Red User", "Lightblue User", "Pink User"
    };

    final private String[] lastMassages = {
            "Hi, how are you?", "24K Magic", "I'm GREEN!", "Red is my name", "wasap :)", "Yo!"
    };

    final private String[] times = {
            "12:00", "00:30", "3:23", "8:59", "14:52", "12:23"
    };
    ListView listView;
    ContactListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        TextView current_user_name  = findViewById(R.id.current_user_name);
        ImageView profile_image_currentUser = findViewById(R.id.profile_image_currentUser);
        current_user_name.setText("daniel karl");
        profile_image_currentUser.setImageResource(R.drawable.profileimage);
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < lastMassages.length; i++) {
            Contact contact = new Contact(userNames[i], lastMassages[i], new Date());
            contacts.add(contact);
        }
        ImageButton addContact = findViewById(R.id.addContact);
        listView = findViewById(R.id.list_view);
        adapter = new ContactListAdapter(getApplicationContext(), contacts);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

            intent.putExtra("userName", userNames[i]);
            intent.putExtra("lastMassage", lastMassages[i]);
            intent.putExtra("time", times[i]);

            startActivity(intent);
        });
        addContact.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddContactActivity.class);

            startActivity(intent);
        });

    }
}