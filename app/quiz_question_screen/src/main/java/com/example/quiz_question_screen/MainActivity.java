package com.example.quiz_question_screen;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.progressContainer);
        for (int i = 0; i < 10; i++) {
            View part = new View(this);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            part.setLayoutParams(params);

            if (i < 2)
                part.setBackgroundColor(Color.parseColor("#4CAF50"));
            else
                part.setBackgroundColor(Color.parseColor("#E0E0E0"));

            container.addView(part);
        }
    }
}
