package com.java_practice_code.designpattern.adapter.service;

import com.java_practice_code.designpattern.adapter.product.Product;

import java.util.List;

public class ShopInventory {
    private List<Product> productList;

    public ShopInventory(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }

    public void showProducts() {
        productList.forEach(System.out::println);
    }
}
