package com.example.quizzapp;

public class LB_items {
    String rank, name, points;
    int userId;

    public LB_items(String rank, String name, String points, int userId){
        this.rank = rank;
        this.name = name;
        this.points = points;
        this.userId = userId;
    }

    public int getUserId() { return userId; }
    public String getRank() { return rank; }
    public String getName() { return name; }
    public String getPoints() { return points; }
}
