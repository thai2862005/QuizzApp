package com.example.quizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import API.ApiClient;
import API.ApiService;
import model.Request;
import model.Respone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    ApiService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(this, "Đang ở login activity", Toast.LENGTH_SHORT).show();

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        api = ApiClient.getClient().create(ApiService.class);

        btnLogin.setOnClickListener(v -> {
            String email = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            Request request = new Request(email, password);

            api.login(request).enqueue(new Callback<Respone>() {
                @Override
                public void onResponse(Call<Respone> call, Response<Respone> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Respone res = response.body();
                        String token = res.getAccess_token();
                        String message = res.getMessage();

                        if (token != null && !token.isEmpty()) {
                            SharedPreferences prefs = getSharedPreferences("QuizzApp", MODE_PRIVATE);
                            prefs.edit().putString("token", token).apply();

                            Toast.makeText(login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(login.this,
                                    message != null ? message : "Đăng nhập thất bại",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(login.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Respone> call, Throwable t) {
                    Toast.makeText(login.this,
                            "Không thể kết nối server: " + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
