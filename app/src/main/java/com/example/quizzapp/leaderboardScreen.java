package com.example.quizzapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import API.ApiClient;
import API.ApiService;
import Auth.AuthToken;
import model_User.UserResponse;
import model_User.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class leaderboardScreen extends AppCompatActivity {

    ListView lvLeaderBoard;
    ArrayList<LB_items> arrLBitems;
    LB_Adapter adapter;
    ApiService api;
    Button btnshow, btnBack;

    // --- Top 3 Views ---
    TextView tvTop1Name, tvTop1Point;
    TextView tvTop2Name, tvTop2Point;
    TextView tvTop3Name, tvTop3Point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard_screen);

        // Check token
        if (!AuthToken.checkAuth(this)) {
            finish();
            return;
        }

        btnshow = findViewById(R.id.btnshow);
        btnBack = findViewById(R.id.btnback);

        btnBack.setOnClickListener(v -> finish());

        btnshow.setOnClickListener(v -> {
            CustomMenu customMenu = new CustomMenu(leaderboardScreen.this);
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

        // set up top 1 2 3
        tvTop1Name = findViewById(R.id.tvTop1Name);
        tvTop1Point = findViewById(R.id.tvTop1Point);
        tvTop2Name = findViewById(R.id.tvTop2Name);
        tvTop2Point = findViewById(R.id.tvTop2Point);
        tvTop3Name = findViewById(R.id.tvTop3Name);
        tvTop3Point = findViewById(R.id.tvTop3Point);

        lvLeaderBoard = findViewById(R.id.lv_leaderboard);
        arrLBitems = new ArrayList<>();

        int currentUserId = getSharedPreferences("QuizzApp", MODE_PRIVATE)
                .getInt("userId", -1);

        adapter = new LB_Adapter(this, R.layout.item_leaderboard, arrLBitems, currentUserId);
        lvLeaderBoard.setAdapter(adapter);

        loadTop3Users();
    }
//top 1 2 3
    private void loadTop3Users() {
        api = ApiClient.getClient(this).create(ApiService.class);

        api.getTopScore().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (!response.isSuccessful() || response.body() == null) return;

                List<User> users = response.body().getUsers();
                if (users == null || users.size() == 0) return;
                for (User u : users) {
                    int total = 0;
                    if (u.getResults() != null) {
                        for (model_result.Result r : u.getResults()) {
                            total += r.getSum();
                        }
                    }
                    u.setSum(total);
                }

                Collections.sort(users, (a, b) -> b.getSum() - a.getSum());
                showTopUser(users);
                loadTopNextUsers();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("API", "Top 1-3 Error: " + t.getMessage());
            }
        });
    }

    private void showTopUser(List<User> users) {
        if (users.size() > 0) setUserTop(users.get(0), tvTop1Name, tvTop1Point);
        if (users.size() > 1) setUserTop(users.get(1), tvTop2Name, tvTop2Point);
        if (users.size() > 2) setUserTop(users.get(2), tvTop3Name, tvTop3Point);
    }

    private void setUserTop(User user, TextView name, TextView point) {
        name.setText(user.getName());
        point.setText(user.getSum() + " points");
    }

 //top 4 -> 10
    private void loadTopNextUsers() {

        api.getTopScoresNext().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (!response.isSuccessful() || response.body() == null) return;

                List<User> users = response.body().getUsers();
                arrLBitems.clear();

                int rank = 4;

                for (User u : users) {
                    int total = 0;

                    if (u.getResults() != null) {
                        for (model_result.Result r : u.getResults()) {
                            total += r.getSum();
                        }
                    }

                    u.setSum(total);

                    arrLBitems.add(new LB_items(
                            String.valueOf(rank),
                            u.getName(),
                            total + " points",
                            u.getId()
                    ));

                    rank++;
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("API", "Top 4-10 Error: " + t.getMessage());
            }
        });
    }
}
