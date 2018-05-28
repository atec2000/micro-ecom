package com.microecom.mecordercommand.service;

import com.microecom.mecordercommand.exception.GetProductException;
import com.microecom.mecordercommand.exception.InsufficientQuantityException;
import com.microecom.mecordercommand.exception.UnavailableProductException;
import com.microecom.mecordercommand.feign.CatalogQueryFeignClient;
import com.microecom.mecordercommand.mapper.LineItemMapper;
import com.microecom.mecordercommand.mapper.UserOrderMapper;
import com.microecom.mecordercommand.messaging.source.OrderCreatedSource;
import com.microecom.mecordercommand.model.LineItem;
import com.microecom.mecordercommand.model.Product;
import com.microecom.mecordercommand.model.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private LineItemMapper lineItemMapper;

    @Autowired
    OrderCreatedSource orderCreatedSource;

    @Autowired
    private CatalogQueryFeignClient catalogQueryFeignClient;

    public UserOrder createUserOrder(UserOrder userOrder) {
        String id = UUID.randomUUID().toString();

        List<String> productIds = new ArrayList<String>();
        for (LineItem lineItem : userOrder.getLineItems()) {
            productIds.add(lineItem.getProductId());
        }
        Iterable<Product> products = catalogQueryFeignClient.findAllById(productIds);
        if (products == null) throw new GetProductException("Failed to get product");

        for (LineItem lineItem : userOrder.getLineItems()) {
            Product currProduct = null;
            for (Product product: products) {
                if (product.getId().equals(lineItem.getProductId())) {
                    currProduct = product;
                    lineItem.setProductName(product.getName());
                    lineItem.setUnitPrice(product.getUnitPrice());
                    break;
                }
            }
            if (currProduct == null) throw new UnavailableProductException(lineItem.getProductId() + " is not available.");
            if (currProduct.getQuantity() < lineItem.getQuantity())
                    throw new InsufficientQuantityException(currProduct.getName() + " has no sufficient quantities.");

            String lineItemId = UUID.randomUUID().toString();
            lineItem.setLineItemId(lineItemId);
            lineItem.setUserOrderId(id);
            lineItemMapper.insert(lineItem);
        }

        userOrder.setUserOrderId(id);
        userOrderMapper.insert(userOrder);

        /*
         * send message to RabbitMQ
         */
        orderCreatedSource.orderCreatedChannel().send(MessageBuilder.withPayload(userOrder).build());

        return userOrder;
    }

}
