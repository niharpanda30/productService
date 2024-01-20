package com.example.productservicemwfeve.service;

import com.example.productservicemwfeve.dtos.FakeStoreProductDto;
import com.example.productservicemwfeve.exceptions.ProductNotExistsException;
import com.example.productservicemwfeve.models.Category;
import com.example.productservicemwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct) {
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }

    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        FakeStoreProductDto productDto = restTemplate.getForObject(
          "https://fakestoreapi.com/products/"+id,
          FakeStoreProductDto.class
        );
        if(productDto == null){
            throw new ProductNotExistsException("Product does not exists for id: "+id);
        }
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
       /* List<FakeStoreProductDto> response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                List<FakeStoreProductDto>.class
        );*/
        //runtime

        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto dto : response){
            products.add(convertFakeStoreProductToProduct(dto));
        }

        return products;
    }

    /*Using Lower levels methods from Res Template instead of using Rest Template directly*/
    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        Product replacedproduct = convertFakeStoreProductToProduct(fakeStoreProductDto);
        return replacedproduct;
    }

    @Override
    public Product addNewproduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }


}
