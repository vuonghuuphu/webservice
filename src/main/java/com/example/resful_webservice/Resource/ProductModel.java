package com.example.resful_webservice.Resource;

import com.example.resful_webservice.Entity.Product;

import java.util.List;

public interface ProductModel {
    Product save (Product product);
    Product update (Product product,int id);
    boolean delete(int id);
    List<Product> findall ();
    Product findbyid (int id);
}
