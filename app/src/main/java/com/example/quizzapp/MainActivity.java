package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import Auth.AuthToken;

public class MainActivity extends AppCompatActivity {
    Button start;
    Button btnLogout;
    Button ldboadrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ldboadrd = findViewById(R.id.leaderboard);
        ldboadrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, leaderboardScreen.class);
                startActivity(intent);
            }
        });
        btnLogout = findViewById(R.id.clear);
        btnLogout.setOnClickListener(v -> {
            AuthToken.clearToken(this);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        start = findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, categories_Screen.class);
                startActivity(intent);
            }
        });
    }
}
