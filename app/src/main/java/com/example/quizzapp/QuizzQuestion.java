package com.example.quizzapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import Auth.AuthToken;

public class QuizzQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!AuthToken.checkAuth(this)) {
            finish(); // đóng activity này lại
            return;
        }

        setContentView(R.layout.activity_quizz_question);
    }
}
