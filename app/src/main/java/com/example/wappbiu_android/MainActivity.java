package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wappbiu_android.api.ContactAPI;
import com.example.wappbiu_android.api.UserAPI;
import com.example.wappbiu_android.daos.ContactDao;
import com.example.wappbiu_android.databinding.ActivityMainBinding;
import com.example.wappbiu_android.entities.Contact;
import com.example.wappbiu_android.entities.User;
import com.example.wappbiu_android.repositories.ContactsRepository;
import com.example.wappbiu_android.viewmodels.LoginViewModel;
import com.example.wappbiu_android.viewmodels.RegisterViewModel;
import com.google.gson.Gson;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
//    private AppDB db;
//    private ContactDao contactDao;
    private LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "WAppBiuDB.db")
//                .allowMainThreadQueries().build();
//        contactDao = db.contactDao();
//        Gson gson = new Gson();
//        String myJson = gson.toJson(contactDao);

        Button btnLogin = binding.btnLogin;
        TextView RegiSuggest = binding.RegiSuggest;
        ImageButton settingsLink = findViewById(R.id.settingsLink);
        EditText editTextLoginUserName = binding.editTextLoginUserName;
        EditText editTextLoginPassword = binding.editTextLoginPassword;
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        btnLogin.setOnClickListener(v -> {
            UserAPI userAPI = new UserAPI();
            userAPI.login(new User(editTextLoginUserName.getText().toString(),"",
                    editTextLoginPassword.getText().toString()), loginViewModel);
        });
        RegiSuggest.setOnClickListener(v -> {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        });
        settingsLink.setOnClickListener(view -> {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        });
        loginViewModel.getError().observe(this, error -> binding.errorLogin.setText(error));
        loginViewModel.getError().observe(this, error -> update(error.toString(), editTextLoginUserName));
    }

    private void update(String e, EditText et) {
        Intent i = new Intent(this, ContactsActivity.class);
        i.putExtra("logged_user", et.getText().toString());
        if (e.equals("")) {
            startActivity(i);
        }
    }
}