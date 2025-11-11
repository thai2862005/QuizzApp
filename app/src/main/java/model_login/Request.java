package model_login;

public class Request {
    private  String email;
    private  String password;

    public Request(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
