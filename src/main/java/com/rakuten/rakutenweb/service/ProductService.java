package com.rakuten.rakutenweb.service;

import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements ProductServices{

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public Product getProductByID(long id) {
        Optional<Product> optional = repo.findById(id);
        Product product = null;
        if(optional.isPresent()){
            product = optional.get();
        }else{
            throw new RuntimeException("Product not found with ID:" + id);
        }
        return repo.findById(id).get();
    }

    public void deleteProductByID(long id) {
        repo.deleteById(id);
    }
}
