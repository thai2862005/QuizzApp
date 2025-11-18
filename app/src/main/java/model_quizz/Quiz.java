package model_quizz;

import java.util.List;

public class Quiz {
    private  int id;
    private String title;
    private String description;
    private  int userId;
    private List<Question> questions;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
