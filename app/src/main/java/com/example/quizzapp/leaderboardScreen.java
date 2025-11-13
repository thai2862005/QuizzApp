package com.example.quizzapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Auth.AuthToken;

public class leaderboardScreen extends AppCompatActivity {

    ListView lvLeaderBoard;
    ArrayList<LB_items> arrLBitems;
    LB_Adapter adapter;
    Button btnshow;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (!AuthToken.checkAuth(this)) {
//            finish();
//            return;
//        }
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
//         ----- ListView -----
        lvLeaderBoard = findViewById(R.id.lv_leaderboard);
//        Dữ liệu mẫu
        //data
        //name
        //sum

        arrLBitems = new ArrayList<>();
        arrLBitems.add(new LB_items("4","Hoang Hong Thai","700 points"));
        arrLBitems.add(new LB_items("5","Hoang ","700 points"));
        arrLBitems.add(new LB_items("6","Hoang Hong Thai","700 points"));
        arrLBitems.add(new LB_items("7","Hong Thai","700 points"));
        arrLBitems.add(new LB_items("8","Hoang Thai","700 points"));
        arrLBitems.add(new LB_items("8"," Thai","700 points"));
        arrLBitems.add(new LB_items("9","Nhi pro","700 points"));
        arrLBitems.add(new LB_items("10","mega live","700 points"));

        adapter = new LB_Adapter(this,R.layout.item_leaderboard,arrLBitems);
        lvLeaderBoard.setAdapter(adapter);

    }
}
