package com.microecom.catalogcommand.producer;

import com.microecom.catalogcommand.messaging.source.ProductsCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ProductsCreatedSource.class)
public class ProductsCreatedProducer {
}
