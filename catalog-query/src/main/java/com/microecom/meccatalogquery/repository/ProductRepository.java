package com.microecom.meccatalogquery.repository;

import com.microecom.meccatalogquery.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

//    Page<Product> findByName(String Name, Pageable pageable);

}
