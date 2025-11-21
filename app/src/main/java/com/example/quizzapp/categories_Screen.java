package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import API.ApiClient;
import API.ApiService;
import model_quizz.Quiz;
import model_quizz.QuizzRespone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class categories_Screen extends AppCompatActivity {

    Button btnshow, btnBack;
    ArrayList<Categories_Items> arrCate;
    Categories_Adapter adapter;
    ListView lv_categories;
    ApiService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories_screen);

        btnshow = findViewById(R.id.btnshow);
        btnBack = findViewById(R.id.btnback);
        lv_categories = findViewById(R.id.lv_categories);

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

        arrCate = new ArrayList<>();
        adapter = new Categories_Adapter(this, R.layout.item_categories, arrCate);
        lv_categories.setAdapter(adapter);

        lv_categories.setOnItemClickListener((parent, view, position, id) -> {
            Categories_Items item = arrCate.get(position);
            Intent intent = new Intent(categories_Screen.this, QuizzQuestion.class);
            intent.putExtra("categoryId", item.getCateId());
            startActivity(intent);
        });

        loadCateData();
    }

    private void loadCateData() {
        api = ApiClient.getClient(this).create(ApiService.class);
        api.getQuizzRespone().enqueue(new Callback<QuizzRespone>() {
            @Override
            public void onResponse(Call<QuizzRespone> call, Response<QuizzRespone> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    Toast.makeText(categories_Screen.this, "Server error", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Quiz> quizzes = response.body().getQuizzes();
                if (quizzes == null || quizzes.isEmpty()) {
                    Toast.makeText(categories_Screen.this, "Không có quiz nào", Toast.LENGTH_SHORT).show();
                    return;
                }

                arrCate.clear();

                for (Quiz q : quizzes) {
                    int totalQuestions = (q.getQuestions() != null) ? q.getQuestions().size() : 0;

                    // Chọn màu nền
                    int bgColor;
                    switch (q.getId() % 5) {
                        case 0: bgColor = 0xFFE57373; break;
                        case 1: bgColor = 0xFF64B5F6; break;
                        case 2: bgColor = 0xFF81C784; break;
                        case 3: bgColor = 0xFFFFB74D; break;
                        case 4: bgColor = 0xFFBA68C8; break;
                        default: bgColor = 0xFFFFFFFF; break;
                    }

                    // Chọn icon theo ID (ví dụ)
                    int iconRes;
                    switch (q.getId()) {
                        case 1: iconRes = R.drawable.icon_java; break;
                        case 2: iconRes = R.drawable.icon_js; break;
                        case 3: iconRes = R.drawable.icon_c; break;
                        case 4: iconRes = R.drawable.icon_python; break;
                        default: iconRes = R.drawable.ranking_star_solid_full; break;
                    }


                    arrCate.add(new Categories_Items(
                            q.getId(),
                            q.getTitle(),
                            totalQuestions + " Questions",
                            iconRes,    // icon thay đổi
                            bgColor
                    ));
                }


                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<QuizzRespone> call, Throwable t) {
                Toast.makeText(categories_Screen.this, "API Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
