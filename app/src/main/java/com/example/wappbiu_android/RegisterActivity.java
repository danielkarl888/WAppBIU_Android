package com.example.wappbiu_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wappbiu_android.api.UserAPI;
import com.example.wappbiu_android.api.WebServiceAPI;
import com.example.wappbiu_android.databinding.ActivityMainBinding;
import com.example.wappbiu_android.databinding.ActivityRegisterBinding;
import com.example.wappbiu_android.entities.User;
import com.example.wappbiu_android.viewmodels.RegisterViewModel;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private RegisterViewModel registerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Button btnRegister = binding.btnRegister;
        TextView LoginSuggest = binding.LoginSuggest;
        ImageButton settingsLink2 = findViewById(R.id.settingsLink2);
        EditText editTextRegiUserName =binding.editTextRegiUserName;
        EditText editTextRegiPassword =binding.editTextRegiPassword;
        EditText editTextRegiDisplayName =binding.editTextRegiDisplayName;
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        btnRegister.setOnClickListener(v -> {
            //Intent i = new Intent(this, ContactsActivity.class);
            UserAPI userAPI = new UserAPI();

            userAPI.regi(new User(editTextRegiUserName.getText().toString(),editTextRegiDisplayName.getText().toString(),
                    editTextRegiPassword.getText().toString()), registerViewModel);
        });
        LoginSuggest.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
        settingsLink2.setOnClickListener(view -> {
            Intent i = new Intent(this, SettingsActivity.class);

            startActivity(i);
        });
        registerViewModel.getError().observe(this, error -> binding.errorRegi.setText(error));
        registerViewModel.getError().observe(this, error -> update(error.toString(), binding.editTextRegiUserName));

    }

    private void update(String e, EditText et) {

        Intent i = new Intent(this, ContactsActivity.class);
        i.putExtra("logged_user", et.getText().toString());
        if (e.equals("")) {
            startActivity(i);
        }
    }
}