package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class signUp extends AppCompatActivity {
    TextView txtSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        txtSignIn = findViewById(R.id.txtSignin);
        txtSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(signUp.this, login.class);
            startActivity(intent);
        }
        );
    }
}