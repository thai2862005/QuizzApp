package com.example.quizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import API.ApiClient;
import API.ApiService;
import Auth.AuthToken;
import model_quizz.Answer;
import model_quizz.Question;
import model_quizz.Quiz;
import model_quizz.QuizzRespone;
import model_save.RequestSubmitScore;
import model_save.ResponeSave;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;


public class QuizzQuestion extends AppCompatActivity {
    private TextView tvTimer;
    private CountDownTimer countDownTimer;

    private static final long TOTAL_TIME = 30 * 60 * 1000;


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

        if (!AuthToken.checkAuth(this)) {
            finish();
            return;
        }

        lvQuizz = findViewById(R.id.lvQuizz);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvTimer = findViewById(R.id.timer);
        startTimer();

        quizzId = getIntent().getIntExtra("categoryId", -1);
        if (quizzId == -1) {
            Toast.makeText(this, "Không tìm thấy Quiz ID", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        btnSubmit.setOnClickListener(v -> submitQuiz());
        loadQuizzData();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(TOTAL_TIME, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                int remainSeconds = seconds % 60;

                String timeFormatted = String.format("%02d:%02d", minutes, remainSeconds);
                tvTimer.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                showTimeUpDialog();
            }
        }.start();
    }

    private void showTimeUpDialog() {

        new AlertDialog.Builder(this)
                .setTitle("Hết thời gian")
                .setMessage("Thời gian làm bài đã hết. Bài sẽ được nộp.")
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, which) -> {
                    submitQuiz();
                })
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
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

                Quiz quizTarget = null;
                for (Quiz q : quizzes) {
                    if (q.getId() == quizzId) {
                        quizTarget = q;
                        break;
                    }
                }

                if (quizTarget == null) {
                    Toast.makeText(QuizzQuestion.this, "Quiz không tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }

                arrQuizzs = new ArrayList<>();
                for (Question q : quizTarget.getQuestions()) {
                    String A = "", B = "", C = "", D = "";
                    int correctIndex = -1;

                    List<Answer> answers = q.getAnswers();
                    if (answers.size() >= 4) {
                        A = answers.get(0).getContent();
                        B = answers.get(1).getContent();
                        C = answers.get(2).getContent();
                        D = answers.get(3).getContent();
                        for (int i = 0; i < answers.size(); i++) {
                            if (answers.get(i).isCorrect()) correctIndex = i;
                        }
                    }

                    arrQuizzs.add(new Quizz_items(
                            "Câu " + q.getId(),
                            q.getContent(),
                            A, B, C, D,
                            correctIndex
                    ));
                }

                adapter = new Quizz_Adapter(QuizzQuestion.this, R.layout.item_quizz, arrQuizzs);
                lvQuizz.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<QuizzRespone> call, Throwable t) {
                Toast.makeText(QuizzQuestion.this, "Lỗi kết nối API", Toast.LENGTH_SHORT).show();
                Log.e("API", "Quizz load error: " + t.getMessage());
            }
        });
    }

    private void submitQuiz() {
        int score = 0;
        for (Quizz_items item : arrQuizzs) {
            if (item.userChoice == item.correctIndex) {
                score += 20;
            }
        }

        SharedPreferences prefs = getSharedPreferences("QuizzApp", MODE_PRIVATE);
        int userId = prefs.getInt("userId", -1);
        String token = prefs.getString("token", null);

        if (userId == -1 || token == null) {
            Toast.makeText(this, "Bạn chưa đăng nhập!", Toast.LENGTH_SHORT).show();
            return;
        }

        sendScoreToServer(quizzId, userId, score, token);
    }

    private void sendScoreToServer(int quizId, int userId, int score, String token) {
        api = ApiClient.getClient(this).create(ApiService.class);
        RequestSubmitScore body = new RequestSubmitScore(quizId, userId, score);

        api.saveScore("Bearer " + token, body).enqueue(new Callback<ResponeSave>() {
            @Override
            public void onResponse(Call<ResponeSave> call, Response<ResponeSave> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(QuizzQuestion.this, "Điểm đã lưu: " + score, Toast.LENGTH_SHORT).show();
                    Log.d("SAVE_SCORE", "Điểm lưu thành công: " + score);
                    // Chuyển sang màn kết quả ngay sau khi lưu
                    Intent intent = new Intent(QuizzQuestion.this, Results_screen.class);
                    intent.putExtra("score", score);
                    intent.putExtra("total", arrQuizzs.size() * 20);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(QuizzQuestion.this, "Lưu điểm thất bại", Toast.LENGTH_SHORT).show();
                    try {
                        Log.e("SAVE_SCORE", "Lỗi: code " + response.code() +
                                ", body: " + response.errorBody().string());
                    } catch (Exception e) { e.printStackTrace(); }
                }
            }

            @Override
            public void onFailure(Call<ResponeSave> call, Throwable t) {
                Toast.makeText(QuizzQuestion.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("SAVE_SCORE", "Lỗi kết nối: " + t.getMessage());
            }
        });
    }
}
