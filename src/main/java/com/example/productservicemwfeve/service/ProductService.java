package com.example.productservicemwfeve.service;

import com.example.productservicemwfeve.exceptions.ProductNotExistsException;
import com.example.productservicemwfeve.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);

    Product addNewproduct(Product product);

    Product updateProduct(Long id, Product product);

    boolean deleteProduct(Long id);
}