package com.microecom.meccatalogquery.consumer;

import com.microecom.meccatalogquery.messaging.sink.ProductsUpdatedSink;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ProductsUpdatedSink.class)
public class ProductsUpdatedConsumer {
}
