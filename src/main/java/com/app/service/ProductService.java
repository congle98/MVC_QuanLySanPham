package com.app.service;

import com.app.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findALL();
    void save(Product product);
    Product findById(int id);
    void update(int id,Product product);
    void remove(int id);
}
