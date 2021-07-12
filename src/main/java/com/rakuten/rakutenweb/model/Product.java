package com.rakuten.rakutenweb.model;

import javax.persistence.*;

@Entity
public class Product {
    private Long id;
    private String name;
    private String brand;
    private float discountPrice;
    private float price;

    public Product() {
    }

    protected Product(Long id, String name, String brand, float discountPrice, float price) {
        super();
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.discountPrice = discountPrice;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
