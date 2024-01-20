package com.example.productservicemwfeve;

import com.example.productservicemwfeve.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
class ProductServicemwfeveApplicationTests {
    @Autowired
    private ProductRepository productRepository;


    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    @Commit
    void testQueries() {
        productRepository.findByTitleContaining("Nihar");
        productRepository.deleteByTitle("Nihar");
    }

}
