// Product.java
package com.example.shoppingapp;

public class Product {
    private String name;
    private String price;
    private int quantity;

    public Product(String name, String price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
