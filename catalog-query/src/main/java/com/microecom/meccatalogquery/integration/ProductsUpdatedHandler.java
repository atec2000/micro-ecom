package com.microecom.meccatalogquery.integration;

import com.microecom.meccatalogquery.messaging.sink.ProductsUpdatedSink;
import com.microecom.meccatalogquery.model.Product;
import com.microecom.meccatalogquery.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.List;

@EnableBinding(ProductsUpdatedSink.class)
public class ProductsUpdatedHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ProductsUpdatedHandler.class);

    @Autowired
    private ProductService productService;

    @StreamListener(ProductsUpdatedSink.PRODUCTSUPDATEDCHANNEL)
    public void handle(List<Product> products) {
        LOG.info("Products updated event received");

        // Create product document for search
        productService.saveAll(products);
    }

}
