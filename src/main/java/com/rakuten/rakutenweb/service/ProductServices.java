package com.rakuten.rakutenweb.service;

import com.rakuten.rakutenweb.model.Product;

import java.util.List;

public interface ProductServices {

    public List<Product> listAll();

    void save(Product product);

    Product getProductByID(long id);

    void deleteProductByID(long id);

}
