package model_save;

public class RequestSubmitScore {
    private int quizId;
    private User User;
    private int score;

    public RequestSubmitScore(int quizId, int userId, int score) {
        this.quizId = quizId;
        this.User = new User(userId);
        this.score = score;
    }

    public static class User {
        private int id;
        public User(int id) { this.id = id; }
    }
}

