package com.example.quizzapp;

public class Quizz_items {
    private String idCauhoi, ndCauhoi,rdA,rdB, rdC, rdD;
    public Quizz_items (String idCauhoi, String ndCauhoi, String rdA, String rdB, String rdC,String rdD){
        this.idCauhoi = idCauhoi;
        this.ndCauhoi = ndCauhoi;
        this.rdA = rdA;
        this.rdB = rdB;
        this.rdC = rdC;
        this.rdD = rdD;
    }
    public String getIdCauhoi() {return idCauhoi;}
    public String getNdCauhoi() {return ndCauhoi;}

    public String getRdA() {return rdA;}
    public String getRdB() {return rdB;}
    public String getRdC() {return rdC;}
    public String getRdD() {return rdD;}
}
