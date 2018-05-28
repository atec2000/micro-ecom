package com.microecom.catalogcommand.messaging.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProductsUpdatedSource {

    //String PRODUCTSUPDATEDCHANNEL = "productsUpdatedChannel";

    @Output("productsUpdatedChannel")
    MessageChannel productsUpdatedChannel();

}