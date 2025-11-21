package com.example.quizzapp;

import android.content.Intent;
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
import model_SignUp.RequestSignUp;
import model_SignUp.Respone_SignUp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signUp extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmPassword;
    Button btnSignUp;
    TextView tvSignIn,txtBacktohome;
    ApiService api;
    boolean isPasswordVisible = false;
    boolean isConfirmPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Window window = getWindow();
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        // Init views
        txtBacktohome = findViewById(R.id.txtBacktohome);
        etName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvSignIn = findViewById(R.id.txtSignin);

        // Init API
        api = ApiClient.getClient(this).create(ApiService.class);

        // Toggle password visibility
        etPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (etPassword.getRight() - etPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    togglePasswordVisibility(etPassword);
                    return true;
                }
            }
            return false;
        });

        etConfirmPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (etConfirmPassword.getRight() - etConfirmPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    toggleConfirmPasswordVisibility(etConfirmPassword);
                    return true;
                }
            }
            return false;
        });

        // Navigate to Login
        tvSignIn.setOnClickListener(v -> {
            startActivity(new Intent(signUp.this, login.class));
            finish();
        });
        txtBacktohome.setOnClickListener(v -> {
            Intent intent =  new Intent(signUp.this, MainActivity.class);
            startActivity(intent);

        });
        // Handle SignUp
        btnSignUp.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirm = etConfirmPassword.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirm)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            RequestSignUp request = new RequestSignUp(name, email, password, confirm);

            api.register(request).enqueue(new Callback<Respone_SignUp>() {
                @Override
                public void onResponse(Call<Respone_SignUp> call, Response<Respone_SignUp> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Respone_SignUp res = response.body();
                        Toast.makeText(signUp.this, res.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signUp.this, login.class));
                        finish();
                    } else {
                        Toast.makeText(signUp.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Respone_SignUp> call, Throwable t) {
                    Toast.makeText(signUp.this, "Không thể kết nối server: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void togglePasswordVisibility(EditText editText) {
        if (isPasswordVisible) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessible_off, 0);
        } else {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessibility_on, 0);
        }
        isPasswordVisible = !isPasswordVisible;
        editText.setSelection(editText.getText().length());
    }

    private void toggleConfirmPasswordVisibility(EditText editText) {
        if (isConfirmPasswordVisible) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessible_off, 0);
        } else {
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessibility_on, 0);
        }
        isConfirmPasswordVisible = !isConfirmPasswordVisible;
        editText.setSelection(editText.getText().length());
    }
}
