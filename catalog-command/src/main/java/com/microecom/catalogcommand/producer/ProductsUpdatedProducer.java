package com.microecom.catalogcommand.producer;

import com.microecom.catalogcommand.messaging.source.ProductsUpdatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ProductsUpdatedSource.class)
public class ProductsUpdatedProducer {
}
