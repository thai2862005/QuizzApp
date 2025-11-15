package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Results_screen extends AppCompatActivity {
        Button btnBack,btnTryAgain;
        Button btnshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results_screen);
        btnBack = findViewById(R.id.btnBack);
        btnTryAgain = findViewById(R.id.btnTryAgain);
        btnBack.setOnClickListener(v -> finish());
        btnshow = findViewById(R.id.btnshow);
        btnshow.setOnClickListener(v -> {
            View popupView = getLayoutInflater().inflate(R.layout.custom_menu, null);

            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    true
            );

            popupWindow.showAsDropDown(v, 0, -40);
        });
    }
}