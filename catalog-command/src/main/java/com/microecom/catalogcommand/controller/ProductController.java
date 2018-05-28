package com.microecom.catalogcommand.controller;

import com.microecom.catalogcommand.model.Product;
import com.microecom.catalogcommand.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
	
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    //@Autowired
    //FoodOrderSource foodOrderSource;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    //@SendTo(Source.OUTPUT)
    //@SendTo(ProductsCreatedSource.PRODUCTCREATEDCHANNEL)
    public Iterable<Product> createUserOrder(@RequestBody List<Product> products) {
        LOG.info(Product.class.getSimpleName() + " request received");

        Iterable<Product> productsCreated = productService.createProducts(products);

        return productsCreated;
    }

}
