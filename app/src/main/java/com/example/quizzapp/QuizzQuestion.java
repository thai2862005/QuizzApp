package com.example.quizzapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Auth.AuthToken;

public class QuizzQuestion extends AppCompatActivity {
    ListView lvQuizz;
    ArrayList<Quizz_items> arrQuizzs;
    Quizz_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (!AuthToken.checkAuth(this)) {
//            finish(); // đóng activity này lại
//            return;
//        }
        setContentView(R.layout.activity_quizz_question);
        arrQuizzs = new ArrayList<>();
        arrQuizzs.add(new Quizz_items("Câu 1","What is the capital of VietNam?","A. LonDon","B. HaNoi","C. Paris","D. Tokyo"));
        arrQuizzs.add(new Quizz_items("Câu 2","1 + 1 = ?","A. 11","B. 2","C. 3","D. 0"));
        adapter = new Quizz_Adapter(this, R.layout.item_quizz, arrQuizzs);
        lvQuizz.setAdapter(adapter);
    }
}
