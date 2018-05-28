package com.microecom.catalogcommand.service;

import com.microecom.catalogcommand.messaging.source.ProductsCreatedSource;
import com.microecom.catalogcommand.messaging.source.ProductsUpdatedSource;
import com.microecom.catalogcommand.model.LineItem;
import com.microecom.catalogcommand.model.Product;
import com.microecom.catalogcommand.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    ProductsCreatedSource productsCreatedSource;

    @Autowired
    ProductsUpdatedSource productsUpdatedSource;

    @Transactional
    public Iterable<Product> createProducts(List<Product> products) {

        //String id = UUID.randomUUID().toString();
        //product.setId(id);
        Iterable<Product> productsCreated = productRepository.saveAll(products);

        productsCreatedSource.productsCreatedChannel().send(MessageBuilder.withPayload(productsCreated).build());

        return productsCreated;
    }

    @Transactional
    public void decreaseQuantity(List<LineItem> lineItems) {

        List<Product> products = new ArrayList<Product>();

        for (LineItem lineItem : lineItems) {
            String productId = lineItem.getProductId();
            Integer quantity = lineItem.getQuantity();

            Product product = mongoOperations.findAndModify(
                    query(where("id").is(productId)),
                    new Update().inc("quantity", -quantity),
                    options().returnNew(true),
                    Product.class);
            products.add(product);
        }

        productsUpdatedSource.productsUpdatedChannel().send(MessageBuilder.withPayload(products).build());
    }

}
