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
        Button btnshow,backToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results_screen);
        btnBack = findViewById(R.id.btnBack);
        backToMenu = findViewById(R.id.btnback);
        btnTryAgain = findViewById(R.id.btnTryAgain);
        //back to home
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Results_screen.this, MainActivity.class);
            startActivity(intent);
        });
        //back menu
        backToMenu.setOnClickListener(v -> {
            finish();
        });
        btnTryAgain.setOnClickListener(v -> {
            Intent intent = new Intent(Results_screen.this, categories_Screen.class);
            startActivity(intent);
        });
        btnshow = findViewById(R.id.btnshow);
        btnshow.setOnClickListener(v -> {
            CustomMenu customMenu = new CustomMenu(Results_screen.this);
            PopupWindow popupWindow = new PopupWindow(
                    customMenu,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    true
            );

            popupWindow.showAsDropDown(v, 0, -40);
        });
    }
}