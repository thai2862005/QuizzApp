package model_User;

import java.util.List;

import model_result.Result;

public class User {
    private int id;
    private String name;
    private String email;
    private int roleId;
    private int sum;
    private List<Result> results;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getRoleId() { return roleId; }
    public int getSum() { return sum; }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<Result> getResults() { return results; }
}

