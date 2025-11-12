package com.example.quizzapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import Auth.AuthToken;

public class leaderboardScreen extends AppCompatActivity {

    Button btnshow;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!AuthToken.checkAuth(this)) {
            finish();
            return;
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard_screen);

        btnshow = findViewById(R.id.btnshow);
        btnBack = findViewById(R.id.btnback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomMenu customMenu = new CustomMenu(leaderboardScreen.this);
                PopupWindow popupWindow = new PopupWindow(
                        customMenu,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        true
                );
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                popupWindow.showAsDropDown(v, 0, -20);
            }
        });
    }
}
