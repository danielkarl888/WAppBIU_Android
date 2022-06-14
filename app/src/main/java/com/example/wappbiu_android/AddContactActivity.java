package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.wappbiu_android.api.ContactAPI;
import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.databinding.ActivityAddContactBinding;
import com.example.wappbiu_android.databinding.ActivityMainBinding;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.viewmodels.ContactsViewModel;
import com.google.gson.Gson;

public class AddContactActivity extends AppCompatActivity {
    private ActivityAddContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddContactBinding.inflate(getLayoutInflater());
        Intent inte = getIntent();
        ContactDao contactDao = ContactsActivity.contactDao;
        String logged_user = inte.getExtras().getString("logged_user");
        setContentView(binding.getRoot());
        EditText editTextAddNickName = binding.editTextAddNickName;
        EditText editTextAddUsername = binding.editTextAddUsername;
        EditText editTextAddServer = binding.editTextAddServer;
        Button btnAddContact = binding.btnAddContact;
        btnAddContact.setOnClickListener(v -> {
            Intent i = new Intent(this, ContactsActivity.class);
            Contact newContact = new Contact(editTextAddUsername.getText().toString(),
                                            editTextAddNickName.getText().toString(),
                                            editTextAddServer.getText().toString());
            contactDao.insert(newContact);
            ContactAPI contactAPI = new ContactAPI(logged_user);
            contactAPI.addContact(newContact);
            contactAPI.invite(newContact, logged_user);
            i.putExtra("logged_user", logged_user);
            startActivity(i);
        });

    }
}