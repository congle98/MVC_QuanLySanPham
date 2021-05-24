package com.app.models;

public class Product {
    private int id;
    private String name;
    private String classify;
    private Double price;
    private String describe;

    public Product() {
    }

    public Product(int id,String name, String classify, Double price, String describe) {
        this.name = name;
        this.classify = classify;
        this.price = price;
        this.describe = describe;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
