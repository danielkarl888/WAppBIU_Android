package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.databinding.ActivityMainBinding;
import com.example.wappbiu_android.entities.Contact;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppDB db;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "WAppBiuDB")
                .allowMainThreadQueries().build();

        contactDao = db.contactDao();

        //Button btnLogin = findViewById(binding.btnLogin);
        Button btnLogin = binding.btnLogin;
        TextView RegiSuggest = binding.RegiSuggest;
        ImageButton settingsLink = findViewById(R.id.settingsLink);

        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(this, ContactsActivity.class);
            //Contact c = new Contact(binding.editTextTextPersonName.getText().toString(), binding.editTextTextPassword2.getText().toString(),
                    //new Date());
            //contactDao.insert(c);
            startActivity(i);
        });
        RegiSuggest.setOnClickListener(v -> {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        });

        settingsLink.setOnClickListener(view -> {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        });
    }
}