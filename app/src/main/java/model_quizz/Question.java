package model_quizz;

import java.util.List;

public class Question {
    private int id;
    private  String content;
    private  int quizId;

    private List<Answer>answers;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getQuizId() {
        return quizId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
