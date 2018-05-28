package com.microecom.meccatalogquery.controller;

import com.microecom.meccatalogquery.model.Product;
import com.microecom.meccatalogquery.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
	
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Iterable<Product> findAllById(@RequestParam("ids") List<String> ids) {
        LOG.info("Get products request received");

        return productService.findAllById(ids);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Product getProduct(@PathVariable String productId) {
        LOG.info("Get product " + productId + " request received");

        return productService.findOne(productId);
    }

}
