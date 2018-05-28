package com.microecom.catalogcommand.messaging.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderCreatedSink {

    String ORDERCREATEDCHANNEL = "orderCreatedChannel";

    @Input("orderCreatedChannel")
    SubscribableChannel orderCreatedChannel();

}