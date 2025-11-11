package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class signUp extends AppCompatActivity {
    TextView txtSignIn;
    EditText etPassword;
    EditText etConfirmPassword;
    Boolean isPasswordVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        txtSignIn = findViewById(R.id.txtSignin);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

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
        etConfirmPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2; // icon nằm bên phải

            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (etConfirmPassword.getRight() - etConfirmPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                    if (isPasswordVisible) {
                        // Ẩn mật khẩu
                        etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        etConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessible_off, 0);
                        isPasswordVisible = false;
                    } else {
                        // Hiện mật khẩu
                        etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        etConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.outline_accessibility_on, 0);
                        isPasswordVisible = true;
                    }

                    etConfirmPassword.setSelection(etConfirmPassword.getText().length());
                    return true;
                }
            }
            return false;
        });
        txtSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(signUp.this, login.class);
            startActivity(intent);
        }
        );
    }
}