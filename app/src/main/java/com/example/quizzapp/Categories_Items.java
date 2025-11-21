package com.example.quizzapp;

public class Categories_Items {
    private String CateName, CateQ;
    private Integer CateImg, CateId;
    private int backgroundColor;  // màu background theo chủ đề

    public Categories_Items(Integer cateId, String cateName, String cateQ, Integer cateImg, int backgroundColor) {
        CateId = cateId;
        CateName = cateName;
        CateQ = cateQ;
        CateImg = cateImg;
        this.backgroundColor = backgroundColor;
    }

    public Integer getCateId() { return CateId; }
    public String getCateName() { return CateName; }
    public String getCateQ() { return CateQ; }
    public Integer getCateImg() { return CateImg; }
    public int getBackgroundColor() { return backgroundColor; }
}
