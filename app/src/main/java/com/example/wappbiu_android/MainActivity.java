package com.example.wappbiu_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.wappbiu_android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Button btnLogin = findViewById(binding.btnLogin);
        Button btnLogin = binding.btnLogin;
        TextView RegiSuggest = binding.RegiSuggest;
        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(this, ContactsActivity.class);
            startActivity(i);
        });
        RegiSuggest.setOnClickListener(v -> {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        });
    }
}