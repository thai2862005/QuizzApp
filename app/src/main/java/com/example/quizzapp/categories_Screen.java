package com.example.quizzapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import Auth.AuthToken;

public class categories_Screen extends AppCompatActivity {
    Button btnshow;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories_screen);

        if (!AuthToken.checkAuth(this)) {
            finish();
            return;
        }

        btnshow = findViewById(R.id.btnshow);
        btnBack = findViewById(R.id.btnback);

        btnBack.setOnClickListener(v -> finish());

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
