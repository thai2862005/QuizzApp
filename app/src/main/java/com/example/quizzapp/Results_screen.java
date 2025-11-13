package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Results_screen extends AppCompatActivity {
        Button btnBack,btnTryAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results_screen);
        btnBack = findViewById(R.id.btnBack);
        btnTryAgain = findViewById(R.id.btnTryAgain);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Results_screen.this, MainActivity.class);
            startActivity(intent);
        });
        btnTryAgain.setOnClickListener(v -> {
            Intent intent = new Intent(Results_screen.this, categories_Screen.class);
            startActivity(intent);
        });
    }
}