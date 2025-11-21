package com.example.quizzapp;

public class Categories_Items {
    private String CateName, CateQ;
    private Integer CateImg, CateId;

    public Categories_Items(Integer cateId, String cateName, String cateQ, Integer cateImg ) {
        CateId = cateId;
        CateName = cateName;
        CateQ = cateQ;
        CateImg = cateImg;

    }

    public Integer getCateId() { return CateId; }
    public String getCateName() { return CateName; }
    public String getCateQ() { return CateQ; }
    public Integer getCateImg() { return CateImg; }
}
