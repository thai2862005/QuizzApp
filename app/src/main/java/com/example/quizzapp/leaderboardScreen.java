package com.example.quizzapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import API.ApiClient;
import API.ApiService;
import model_User.UserResponse;
import model_User.User;
import model_result.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class leaderboardScreen extends AppCompatActivity {

    ListView lvLeaderBoard;
    ArrayList<LB_items> arrLBitems;
    LB_Adapter adapter;
    Button btnshow, btnBack;
    ApiService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard_screen);

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
//set variable list component
        lvLeaderBoard = findViewById(R.id.lv_leaderboard);
        arrLBitems = new ArrayList<>();
        adapter = new LB_Adapter(this, R.layout.item_leaderboard, arrLBitems);
        lvLeaderBoard.setAdapter(adapter);

        loadTopUsers();
    }
//logic load động list view
    private void loadTopUsers() {
        api = ApiClient.getClient().create(ApiService.class);
        api.getTopScoresNext().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful() && response.body() != null) {

                    arrLBitems.clear();

                    List<User> users = response.body().getUsers();
                    int rank = 4;

                    for(User u : users) {
                        int totalPoint = 0;
                        if(u.getResults() != null) {
                            for(model_result.Result r : u.getResults()) {
                              totalPoint+=  r.getSum();
                            }
                        }

                        arrLBitems.add(new LB_items(
                                String.valueOf(rank),
                                u.getName(),
                                totalPoint + " points"
                        ));

                        rank++;
                    }

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("API", "Error: " + t.getMessage());
            }
        });
    }
}
