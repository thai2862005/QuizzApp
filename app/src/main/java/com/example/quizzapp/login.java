package com.example.quizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import API.ApiClient;
import API.ApiService;
import Model_account.AccountResponse;
import model_login.Request;
import model_login.Respone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    ApiService api;
    TextView tvSignUp;
    boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Window window = getWindow();
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
        window.getDecorView().setSystemUiVisibility(android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Bind views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);

        api = ApiClient.getClient(this).create(ApiService.class);

        // Toggle password visibility
        etPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (etPassword.getRight() - etPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    if (isPasswordVisible) {
                        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        etPassword.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.outline_accessible_off,0);
                        isPasswordVisible = false;
                    } else {
                        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        etPassword.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.outline_accessibility_on,0);
                        isPasswordVisible = true;
                    }
                    etPassword.setSelection(etPassword.getText().length());
                    return true;
                }
            }
            return false;
        });

        tvSignUp.setOnClickListener(v -> startActivity(new Intent(login.this, signUp.class)));

        btnLogin.setOnClickListener(v -> {
            String email = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,"Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            loginUser(email,password);
        });
    }

    private void loginUser(String email, String password){
        Request request = new Request(email,password);
        api.login(request).enqueue(new Callback<Respone>() {
            @Override
            public void onResponse(Call<Respone> call, Response<Respone> response) {
                if(response.isSuccessful() && response.body() != null){
                    String token = response.body().getAccess_token();
                    if(token != null && !token.isEmpty()){
                        SharedPreferences prefs = getSharedPreferences("QuizzApp", MODE_PRIVATE);
                        prefs.edit().putString("token",token).apply();
                        fetchCurrentUser();
                    } else {
                        Toast.makeText(login.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(login.this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Respone> call, Throwable t) {
                Toast.makeText(login.this,"Không thể kết nối server: "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchCurrentUser(){
        api.getAccount().enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    int userId = response.body().getUser().getId();
                    SharedPreferences prefs = getSharedPreferences("QuizzApp", MODE_PRIVATE);
                    prefs.edit().putInt("userId", userId).commit();
                    Toast.makeText(login.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, leaderboardScreen.class));
                    finish();
                }
            }
            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {
                Toast.makeText(login.this,"Lỗi khi lấy thông tin user: "+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
