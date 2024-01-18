package com.example.productservicemwfeve.service;

import com.example.productservicemwfeve.exceptions.ProductNotExistsException;
import com.example.productservicemwfeve.models.Product;
import com.example.productservicemwfeve.repositories.CategoryRepository;
import com.example.productservicemwfeve.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
