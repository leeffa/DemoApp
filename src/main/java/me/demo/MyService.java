package me.demo;

import me.demo.external.ExternalService;
import me.demo.external.OrderException;

import java.math.BigDecimal;

/**
 * Created by Admin on 3/22/2017.
 */
public class MyService {
    private ExternalService externalService;

    public MyService(){}

    public MyService(ExternalService externalService) {
        this.externalService = externalService;
    }

    public boolean processOrder(Order order) {
        if (!validateOrder(order)) {
            return false;
        }
        try {
            externalService.processOrder(order);
        } catch (OrderException e) {
            return false;
        }
        //return
        return true;
    }

    public Order getOrderDetails(Integer orderId) throws OrderException {
        return externalService.getOrderDetails(orderId);
    }
    private boolean validateOrder(Order order) {

        return order.getItemId() != null && order.getItemId() > 0 &&
                order.getQuantity() != null && order.getQuantity() > 0 &&
                order.getPrice() != null && order.getPrice().compareTo(BigDecimal.ZERO) >= 0;
    }
}
