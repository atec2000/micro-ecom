package com.microecom.meccatalogquery.service;

import com.microecom.meccatalogquery.model.Product;
import com.microecom.meccatalogquery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> saveAll(Iterable<Product> products) {
        return productRepository.saveAll(products);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public Product findOne(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Iterable<Product> findAllById(Iterable<String> ids) {
        return productRepository.findAllById(ids);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

//    public Page<Product> findByName(String name, PageRequest pageRequest) {
//        return productRepository.findByName(name, pageRequest);
//    }

}
