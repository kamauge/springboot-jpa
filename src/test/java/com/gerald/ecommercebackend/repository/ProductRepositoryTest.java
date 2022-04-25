package com.gerald.ecommercebackend.repository;

import com.gerald.ecommercebackend.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProduct(){
        //Create Product
        Product product = new Product();
        product.setActive(true);
        product.setDescription("good working condition");
        product.setPrice(new BigDecimal(100));
        product.setName("Macbook Pro 13.3");
        product.setImageUrl("alien.png");
        product.setSku("105ABC");

        //save product
        Product savedProduct = productRepository.save(product);

        System.out.println(savedProduct.toString());
    }
    @Test
    void saveAllProducts(){
        Product product = new Product();
        product.setActive(true);
        product.setDescription("good working condition");
        product.setPrice(new BigDecimal(100));
        product.setName("Macbook Pro 13");
        product.setImageUrl("macbook13.png");
        product.setSku("102ABC");

        Product product2 = new Product();
        product2.setActive(true);
        product2.setDescription("good working condition");
        product2.setPrice(new BigDecimal(100));
        product2.setName("Macbook Pro 14");
        product2.setImageUrl("macbook14.png");
        product2.setSku("103ABC");

        productRepository.saveAll(List.of(product,product2));
    }

    @Test
    void updateProduct(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        product.setName("Alien ware2");
        product.setPrice(new BigDecimal(150));

        Product updatedProduct = productRepository.save(product);
        System.out.println(updatedProduct.toString());
    }

    @Test
    void findById(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());

    }

    @Test
    void findAllProducts(){
       List<Product> products = productRepository.findAll();

       products.forEach(product -> System.out.println(product.getName()));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

}