package com.example.productservicemwfeve.service;

import com.example.productservicemwfeve.exceptions.ProductNotExistsException;
import com.example.productservicemwfeve.models.Category;
import com.example.productservicemwfeve.models.Product;
import com.example.productservicemwfeve.repositories.CategoryRepository;
import com.example.productservicemwfeve.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotExistsException("The Product is not found fore the id : " + id);
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewproduct(Product product) {
        Category category = product.getCategory();
        Product savedProduct = null;
        if(category != null){
            categoryRepository.save(category);
            savedProduct = productRepository.save(product);
        }
        return savedProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) throw new RuntimeException();
        Product savedProduct = optionalProduct.get();
        if(product.getTitle()!=null)
            savedProduct.setTitle(product.getTitle());
        if(product.getDescription()!=null)
            savedProduct.setDescription(product.getDescription());
        if(product.getPrice()!=null)
            savedProduct.setPrice(product.getPrice());
        if(product.getImageUrl()!=null)
            savedProduct.setImageUrl(product.getImageUrl());
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
