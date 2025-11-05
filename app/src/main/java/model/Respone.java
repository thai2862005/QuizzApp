package model;

public class Respone {
    private  String access_token;
    private  String message;

    public Respone(String message, String access_token) {
        this.message = message;
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getMessage() {
        return message;
    }
}
