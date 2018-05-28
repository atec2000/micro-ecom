package com.microecom.mecordercommand.producer;

import com.microecom.mecordercommand.messaging.source.OrderCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderCreatedSource.class)
public class OrderCreatedProducer {
}
