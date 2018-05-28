package com.microecom.mecordercommand.feign;

import com.microecom.mecordercommand.exception.GetProductException;
import com.microecom.mecordercommand.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "catalog-query", fallback = CatalogQueryFeignClientFallback.class)
public interface CatalogQueryFeignClient {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public Iterable<Product> findAllById(@RequestParam("ids") List<String> ids);

}

@Component
class CatalogQueryFeignClientFallback implements CatalogQueryFeignClient {

    @Override
    public Iterable<Product> findAllById(List<String> ids) {
        //throw new GetProductException("Failed to get product");
        return null;
    }

    /*
    @Override
    public Iterable<Product> findAllById(List<String> ids) {
        Product product = new Product();
        product.setId("0");
        product.setName("default");
        product.setQuantity(0);
        product.setUnitPrice(BigDecimal.ZERO);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product);

        return products;
    }
    */

}