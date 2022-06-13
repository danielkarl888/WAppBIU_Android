package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wappbiu_android.adapters.ContactListAdapter;
import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.Message;
import com.example.wappbiu_android.viewmodels.ContactsViewModel;
import com.example.wappbiu_android.viewmodels.MyViewModelFactory;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsActivity extends AppCompatActivity {
    public static String logged_user;

    private ContactsViewModel contactsViewModel;
    ListView listView;
    ContactListAdapter adapter;
    private AppDB db;
    public static ContactDao contactDao;
    private Map<String, ContactDao> contactDaoMap;
//    final private String[] userNames = {
//            "Blue User", "Golden User", "Green User", "Red User", "Lightblue User", "Pink User"
//    };
//
//    final private String[] lastMassages = {
//            "Hi, how are you?", "24K Magic", "I'm GREEN!", "Red is my name", "wasap :)", "Yo!"
//    };
//
//    final private String[] times = {
//            "12:00", "00:30", "3:23", "8:59", "14:52", "12:23"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Map<String, ContactDao> contactDaoMap = SingeltonContactDaoMap.getInstance().map;
        setContentView(R.layout.activity_contacts);
        Intent in = getIntent();
        logged_user = in.getExtras().getString("logged_user");
        if (contactDaoMap.containsKey(logged_user)) {
            contactDao = contactDaoMap.get(logged_user);

            //Contact c = contactDao.get("raz");
            //List<Message> m  = c.getMessages();

        } else {
            db = Room.databaseBuilder(getApplicationContext(), AppDB.class, logged_user + ".db")
                    .allowMainThreadQueries().build();
            contactDao = db.contactDao();
            contactDaoMap.put(logged_user,contactDao);
        }
        Object[] objects = new Object[2];
        objects[0] = logged_user;
        objects[1] = contactDao;
        contactsViewModel = new ViewModelProvider(this, new MyViewModelFactory(getApplication(), objects)).get(ContactsViewModel.class);
        TextView current_user_name  = findViewById(R.id.current_user_name);
        ImageView profile_image_currentUser = findViewById(R.id.profile_image_currentUser);
        current_user_name.setText(logged_user);
        profile_image_currentUser.setImageResource(R.drawable.profileimage);
        ArrayList<Contact> contacts = new ArrayList<>();
//        for (int i = 0; i < lastMassages.length; i++) {
//            Contact contact = new Contact(userNames[i], lastMassages[i], times[i]);
//            contacts.add(contact);
//        }
        ImageButton addContact = findViewById(R.id.addContact);
        listView = findViewById(R.id.list_view);

        adapter = new ContactListAdapter(getApplicationContext(), contacts);

        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            intent.putExtra("logged_user", logged_user);
            TextView user_name = view.findViewById(R.id.user_name);
            intent.putExtra("contact_name", user_name.getText().toString());


            startActivity(intent);
        });
        addContact.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddContactActivity.class);
            intent.putExtra("logged_user", logged_user);
            startActivity(intent);
        });
        contactsViewModel.get().observe(this, convers -> {
            adapter.setContacts(convers);
        });
    }
     @Override
 protected void onResume() {
         super.onResume();
         adapter.setContacts(contactDao.index());
         Log.i("ContactActivity", "onResume");
    }



}