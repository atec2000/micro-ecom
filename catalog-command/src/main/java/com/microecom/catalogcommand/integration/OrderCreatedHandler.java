package com.microecom.catalogcommand.integration;

import com.microecom.catalogcommand.messaging.sink.OrderCreatedSink;
import com.microecom.catalogcommand.model.UserOrder;
import com.microecom.catalogcommand.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(OrderCreatedSink.class)
public class OrderCreatedHandler {

    private static final Logger LOG = LoggerFactory.getLogger(OrderCreatedHandler.class);

    @Autowired
    private ProductService productService;

    @StreamListener(OrderCreatedSink.ORDERCREATEDCHANNEL)
    public void handle(UserOrder userOrder) {
        LOG.info(userOrder.getUserOrderId() + " order created event received");

        productService.decreaseQuantity(userOrder.getLineItems());
    }

}
