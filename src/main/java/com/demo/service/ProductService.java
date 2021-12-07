package com.demo.service;

import com.demo.model.Product;
import com.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product get(long id) {
        Product product = productRepository.getById(id);
        return product;
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }


}
