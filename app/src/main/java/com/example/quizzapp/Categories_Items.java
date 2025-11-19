package com.example.quizzapp;

public class Categories_Items {
    private String CateName, CateQ;
    private Integer CateImg;

    public Categories_Items(String cateName, String cateQ, Integer cateImg) {
        CateName = cateName;
        CateQ = cateQ;
        CateImg = cateImg;
    }

    public String getCateName() {
        return CateName;
    }

    public String getCateQ() {
        return CateQ;
    }

    public Integer getCateImg() {
        return CateImg;
    }
}


