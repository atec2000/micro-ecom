package com.microecom.catalogcommand.messaging.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProductsCreatedSource {

    //String PRODUCTSCREATEDCHANNEL = "productsCreatedChannel";

    @Output("productsCreatedChannel")
    MessageChannel productsCreatedChannel();

}