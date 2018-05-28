package com.microecom.catalogcommand.repository;

import com.microecom.catalogcommand.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
