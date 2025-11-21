package com.example.quizzapp;

public class Quizz_items {

    private String idCauhoi;
    private String ndCauhoi;
    private String rdA, rdB, rdC, rdD;

    public int correctIndex;
    public int userChoice = -1;

    public Quizz_items(String idCauhoi, String ndCauhoi,
                       String rdA, String rdB, String rdC, String rdD,
                       int correctIndex) {

        this.idCauhoi = idCauhoi;
        this.ndCauhoi = ndCauhoi;
        this.rdA = rdA;
        this.rdB = rdB;
        this.rdC = rdC;
        this.rdD = rdD;

        this.correctIndex = correctIndex;
    }

    public String getIdCauhoi() {
        return idCauhoi;
    }

    public String getNdCauhoi() {
        return ndCauhoi;
    }

    public String getRdA() {
        return rdA;
    }

    public String getRdB() {
        return rdB;
    }

    public String getRdC() {
        return rdC;
    }

    public String getRdD() {
        return rdD;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }
}
