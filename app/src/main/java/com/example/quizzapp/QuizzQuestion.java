package com.example.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import API.ApiClient;
import API.ApiService;
import model_quizz.Answer;
import model_quizz.Question;
import model_quizz.Quiz;
import model_quizz.QuizzRespone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizzQuestion extends AppCompatActivity {

    ListView lvQuizz;
    ArrayList<Quizz_items> arrQuizzs;
    Quizz_Adapter adapter;
    ApiService api;
    Button btnSubmit;
    int quizzId = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quizz_question);

        lvQuizz = findViewById(R.id.lvQuizz);
        btnSubmit = findViewById(R.id.btnSubmit);
        quizzId = getIntent().getIntExtra("categoryId", -1);
        if (quizzId == -1) {
            Toast.makeText(this, "Không tìm thấy Quiz ID", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        // Sự kiện Submit (Nộp bài)
        btnSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(QuizzQuestion.this, Results_screen.class);
            startActivity(intent);
        });

        loadQuizzData();
    }

    private void loadQuizzData() {
        api = ApiClient.getClient(this).create(ApiService.class);

        api.getQuizzRespone().enqueue(new Callback<QuizzRespone>() {
            @Override
            public void onResponse(Call<QuizzRespone> call, Response<QuizzRespone> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    Toast.makeText(QuizzQuestion.this, "Lỗi server", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Quiz> quizzes = response.body().getQuizzes();
                if (quizzes == null || quizzes.isEmpty()) {
                    Toast.makeText(QuizzQuestion.this, "Không có quiz nào", Toast.LENGTH_SHORT).show();
                    return;
                }
//logic lọc theo id
                Quiz quizTarget = null;
                for (Quiz q : quizzes) {
                    if (q.getId() == quizzId) {   // lọc quizId = 1
                        quizTarget = q;
                        break;
                    }
                }

                if (quizTarget == null) {
                    Toast.makeText(QuizzQuestion.this, "Không tìm thấy quizId = 1", Toast.LENGTH_SHORT).show();
                    return;
                }

                arrQuizzs = new ArrayList<>();

                for (Question q : quizTarget.getQuestions()) {

                    String A = "", B = "", C = "", D = "";

                    List<Answer> answers = q.getAnswers();

                    if (answers.size() >= 4) {
                        A = answers.get(0).getContent();
                        B = answers.get(1).getContent();
                        C = answers.get(2).getContent();
                        D = answers.get(3).getContent();
                    }

                    arrQuizzs.add(new Quizz_items(
                            "Câu " + q.getId(),
                            q.getContent(),
                            "A. " + A,
                            "B. " + B,
                            "C. " + C,
                            "D. " + D
                    ));
                }

                adapter = new Quizz_Adapter(QuizzQuestion.this, R.layout.item_quizz, arrQuizzs);
                lvQuizz.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<QuizzRespone> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(QuizzQuestion.this, "Lỗi kết nối API", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
