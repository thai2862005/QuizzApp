package com.example.quizzapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Results_screen extends AppCompatActivity {

    Button btnBackhome,btnshow, btnTryAgain;
    TextView tvScore, tvTotal, tvAccuracy, tvTime, tvMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);

        Window window = getWindow();
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        btnBackhome = findViewById(R.id.btnBackhome);
        btnshow = findViewById(R.id.btnshow);
        btnTryAgain = findViewById(R.id.btnTryAgain);

        tvScore = findViewById(R.id.tvScore);
        tvTotal = findViewById(R.id.tvTotal);
        tvAccuracy = findViewById(R.id.tvAccuracy);
        tvTime = findViewById(R.id.tvTime);
        tvMessage = findViewById(R.id.tvMessage);

        // Nhận dữ liệu từ Intent
        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);
        long timeLeftInMillis = getIntent().getLongExtra("timeUsed", 0);
        long timeUsedInMillis = 600_000 - timeLeftInMillis;

        //dùng lại
        int minutes = (int) (timeUsedInMillis / 1000) / 60;
        int seconds = (int) (timeUsedInMillis / 1000) % 60;
        String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        int scoreafter = score / 20;
        int sum = total / 20;

        tvScore.setText(String.valueOf(scoreafter));
        tvTotal.setText(String.valueOf(sum));

        int accuracy = (total > 0) ? (score * 100 / total) : 0;
        tvAccuracy.setText(accuracy + "%");

        tvTime.setText(timeFormatted);

        String message;
        int color;
        if (accuracy >= 90) {
            message = "Đế vương là phải có long ngai! 🔥";
            color = Color.parseColor("#4CAF50"); // xanh lá
        } else if (accuracy >= 70) {
            message = "Amazing! Good job, gần được rồi!! 😎";
            color = Color.parseColor("#FF9800"); // cam
        } else if (accuracy >= 50) {
            message = "Cũng khá ổn, nhưng còn gà lắm! 😉";
            color = Color.parseColor("#FFC107"); // vàng
        } else {
            message = "Còn gà lắm! 😅";
            color = Color.parseColor("#F44336"); // đỏ
        }
        tvMessage.setText(message);
        tvMessage.setTextColor(color);

        // Back to Home
        btnBackhome.setOnClickListener(v -> {
            Intent intent = new Intent(Results_screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btnshow.setOnClickListener(v ->{
            CustomMenu customMenu = new CustomMenu(Results_screen.this);
            PopupWindow popupWindow = new PopupWindow(
                    customMenu,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    true
            );
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popupWindow.showAsDropDown(v, 0, -20);
        });

        // Try Again
        btnTryAgain.setOnClickListener(v -> {
            Intent intent = new Intent(Results_screen.this, categories_Screen.class);
            startActivity(intent);
            finish();
        });
    }
}
