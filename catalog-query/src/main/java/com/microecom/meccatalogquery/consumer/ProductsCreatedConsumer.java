package com.microecom.meccatalogquery.consumer;

import com.microecom.meccatalogquery.messaging.sink.ProductsCreatedSink;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ProductsCreatedSink.class)
public class ProductsCreatedConsumer {
}
