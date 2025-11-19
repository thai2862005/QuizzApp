package com.example.quizzapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Auth.AuthToken;

public class categories_Screen extends AppCompatActivity {
    Button btnshow;
    Button btnBack,btnBackMenu;
    ArrayList<Categories_Items> arrCate;
    Categories_Adapter adapter;
    ListView lv_categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories_screen);

//        if (!AuthToken.checkAuth(this)) {
//            finish();
//            return;
//        }

        btnshow = findViewById(R.id.btnshow);
        btnBack = findViewById(R.id.btnback);
        btnBack.setOnClickListener(v -> finish());

        btnshow.setOnClickListener(v -> {
            CustomMenu customMenu = new CustomMenu(categories_Screen.this);
            PopupWindow popupWindow = new PopupWindow(
                    customMenu,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    true
            );

            popupWindow.showAsDropDown(v, 0, -40);
        });
        lv_categories = findViewById(R.id.lv_categories);
        arrCate = new ArrayList<>();
        arrCate.add(new Categories_Items("Science","20 Questions",R.mipmap.ic_king_foreground));
        adapter = new Categories_Adapter(this, R.layout.item_categories, arrCate);
        lv_categories.setAdapter(adapter);
    }
}
