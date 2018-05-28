package com.microecom.meccatalogquery.messaging.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ProductsCreatedSink {

    String PRODUCTSCREATEDCHANNEL = "productsCreatedChannel";

    @Input("productsCreatedChannel")
    SubscribableChannel productsCreatedChannel();

}