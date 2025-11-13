package com.example.quizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import API.ApiClient;
import API.ApiService;
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
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        //set variable
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        api = ApiClient.getClient().create(ApiService.class);
        //action hiện tắt mật khẩu
        etPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2; // icon nằm bên phải

            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (etPassword.getRight() - etPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                    if (isPasswordVisible) {
                        // Ẩn mật khẩu
                        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        etPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessible_off, 0);
                        isPasswordVisible = false;
                    } else {
                        // Hiện mật khẩu
                        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        etPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessibility_on, 0);
                        isPasswordVisible = true;
                    }

                    etPassword.setSelection(etPassword.getText().length());
                    return true;
                }
            }
            return false;
        });


        //navigation sign up
        TextView tvSignUp = findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(login.this, signUp.class);
            startActivity(intent);
        });

        //aut đăng nhập dựa theo token
        btnLogin.setOnClickListener(v -> {
            String email = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            //validate
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
