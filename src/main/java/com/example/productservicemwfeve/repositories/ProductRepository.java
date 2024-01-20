package com.example.productservicemwfeve.repositories;

import com.example.productservicemwfeve.models.Category;
import com.example.productservicemwfeve.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends
        JpaRepository<Product, Long> {

    List<Product> findByTitleContaining(String word);

    long deleteByTitle(@NonNull String title);

    List<Product> findByTitleAndDescription(String title, String description);

    List<Product> findByPriceLessThanEqual(double price);

    List<Product> findByPriceBetween(double startRange, double endRange);

    //This query does an internal join between Product Table and Category Table
    List<Product> findByCategory(Category category);

    //Using "_" to access products and search them by Id
    List<Product> findByCategory_Id(Long id);

}
