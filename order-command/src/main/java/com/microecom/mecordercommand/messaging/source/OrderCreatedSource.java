package com.microecom.mecordercommand.messaging.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderCreatedSource {

    //String ORDERCREATEDCHANNEL = "orderCreatedChannel";

    @Output("orderCreatedChannel")
    MessageChannel orderCreatedChannel();

}