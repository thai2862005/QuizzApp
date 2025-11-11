package model_SignUp;

public class RequestSignUp {
    private String name;
    private String email;
    private String password;
    private  String confirmpassword;
    public RequestSignUp(String name, String email, String password, String confirmpassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmpassword = this.confirmpassword;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }
}
