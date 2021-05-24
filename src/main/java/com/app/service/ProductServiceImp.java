package com.app.service;

import com.app.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService{
    private static Map<Integer,Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"Ngo","Nong San",5000.0,"Ngo Viet Nam"));
        productList.put(2,new Product(2,"Gao","Nong San",10000.0,"Gao Viet Nam"));
        productList.put(3,new Product(3,"Ca tra","Thuy San",30000.0,"Ca tra Viet Nam"));
        productList.put(4,new Product(4,"Go xua","Lam San",1000000.0,"Go xua 1 loại go quy hiem cua Viet Nam"));
    }
    @Override
    public List<Product> findALL() {

        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
