package com.example.quizzapp;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import android.widget.PopupWindow;

public class CustomMenu extends LinearLayout {

    private PopupWindow popupWindow;
    Button btnClose;
    public CustomMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomMenu(Context context) {
        super(context);
        init(context);
    }

    // setter để gán popupWindow từ Activity
    public void setPopupWindow(PopupWindow popupWindow) {
        this.popupWindow = popupWindow;
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_menu, this, true);

        // Nút đóng popup


        // Nút Home
        findViewById(R.id.homepage).setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        });

        // Nút Categories
        findViewById(R.id.categories).setOnClickListener(v -> {
            Intent intent = new Intent(context, categories_Screen.class);
            context.startActivity(intent);
        });

        // Nút Leaderboard
        findViewById(R.id.leaderboard).setOnClickListener(v -> {
            Intent intent = new Intent(context, leaderboardScreen.class);
            context.startActivity(intent);
        });

        // Nút Question
        findViewById(R.id.question).setOnClickListener(v -> {
            Intent intent = new Intent(context, QuizzQuestion.class);
            context.startActivity(intent);
        });

        // Nút Results
        findViewById(R.id.results).setOnClickListener(v -> {
            Intent intent = new Intent(context, Results_screen.class);
            context.startActivity(intent);
        });
    }
}
