package model_SignUp;

public class Respone_SignUp {
    private int id;
    private String name;
    private String email;
    private String password;
    private int roleId;
    private String message;

    public Respone_SignUp(int id, String name, String email, String password, int roleId, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.message = message;
    }

    public int getId() {
        return id;
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

    public int getRoleId() {
        return roleId;
    }

    public String getMessage() {
        return message;
    }
}
