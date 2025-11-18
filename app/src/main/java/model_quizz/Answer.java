package model_quizz;

public class Answer {
    private int id;
    private  String content;
    private boolean isCorrect;
    private int questionId;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public int getQuestionId() {
        return questionId;
    }
}
