package com.microecom.catalogcommand.consumer;

import com.microecom.catalogcommand.messaging.sink.OrderCreatedSink;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderCreatedSink.class)
public class OrderCreatedConsumer {
}
