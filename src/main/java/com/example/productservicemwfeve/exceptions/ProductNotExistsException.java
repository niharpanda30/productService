package com.example.productservicemwfeve.exceptions;

import com.example.productservicemwfeve.service.ProductService;

public class ProductNotExistsException extends Exception{

    public ProductNotExistsException(String message){
        super(message);
    }
}
