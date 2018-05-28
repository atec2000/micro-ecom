package com.microecom.meccatalogquery.integration;

import com.microecom.meccatalogquery.messaging.sink.ProductsCreatedSink;
import com.microecom.meccatalogquery.model.Product;
import com.microecom.meccatalogquery.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.List;

@EnableBinding(ProductsCreatedSink.class)
public class ProductsCreatedHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ProductsCreatedHandler.class);

    @Autowired
    private ProductService productService;

    @StreamListener(ProductsCreatedSink.PRODUCTSCREATEDCHANNEL)
    public void handle(List<Product> products) {
        LOG.info("Product created event received");

        // Create product document for search
        productService.saveAll(products);
    }

}
