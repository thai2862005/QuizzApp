package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Auth.AuthToken;

public class QuizzQuestion extends AppCompatActivity {
    ListView lvQuizz;
    ArrayList<Quizz_items> arrQuizzs;
    Quizz_Adapter adapter;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        if (!AuthToken.checkAuth(this)) {
//            finish(); // đóng activity này lại
//            return;
//        }
        setContentView(R.layout.activity_quizz_question);
//        Sự kiện Submit (Nộp bài)
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizzQuestion.this, categories_Screen.class);
                startActivity(intent);
            }
        });
//        Dữ liệu mẫu
        lvQuizz = findViewById(R.id.lvQuizz);
        arrQuizzs = new ArrayList<>();
        arrQuizzs.add(new Quizz_items("Câu 1","What is the capital of VietNam?","A. LonDon","B. HaNoi","C. Paris","D. Tokyo"));
        arrQuizzs.add(new Quizz_items("Câu 2","1 + 1 = ?","A. 11","B. 2","C. 3","D. 0"));
        adapter = new Quizz_Adapter(this, R.layout.item_quizz, arrQuizzs);
        lvQuizz.setAdapter(adapter);
    }
}
