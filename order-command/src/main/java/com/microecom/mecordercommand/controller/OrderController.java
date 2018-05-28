package com.microecom.mecordercommand.controller;

import com.microecom.mecordercommand.model.UserOrder;
import com.microecom.mecordercommand.service.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
	
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    UserOrderService userOrderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    //@SendTo(Source.OUTPUT)
    //@SendTo(ProductCreatedSource.PRODUCTCREATEDCHANNEL)
    public UserOrder createUserOrder(@RequestBody UserOrder userOrder) {
        LOG.info(UserOrder.class.getSimpleName() + " request received");

        UserOrder userOrderCreated = userOrderService.createUserOrder(userOrder);

        return userOrderCreated;
    }

}
