package com.microecom.meccatalogquery.messaging.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ProductsUpdatedSink {

    String PRODUCTSUPDATEDCHANNEL = "productsUpdatedChannel";

    @Input("productsUpdatedChannel")
    SubscribableChannel productsUpdatedChannel();

}