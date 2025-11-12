package com.example.quizzapp;

public class LB_items {
    private  String rank,name,points;
    public  LB_items (String rank, String name, String points){
        this.rank = rank;
        this.name = name;
        this.points = points;
    }

    public String getRank(){
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getPoints() {
        return points;
    }
}
