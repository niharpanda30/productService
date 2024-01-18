package com.example.productservicemwfeve.controller;

import com.example.productservicemwfeve.exceptions.ProductNotExistsException;
import com.example.productservicemwfeve.models.Product;
import com.example.productservicemwfeve.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id ) throws ProductNotExistsException {
        return new ResponseEntity<>(
            productService.getSingleProduct(id),HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        //return productService.getAllProducts();
        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProducts(), HttpStatus.OK
        );
        return response;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);
    }

    /*This exception handler is prepared to Handle an Exception at the class level.
    * Controller Advices are prepared to handle Exception at Global levels
    * Priority of execution of Controller level Exception is greater than Global level.
    * */
    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<Void> handleProductNotExistsException(){
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
