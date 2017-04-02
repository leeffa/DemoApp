package me.demo.external;

import me.demo.Order;

import java.math.BigDecimal;

/**
 * Created by Admin on 3/22/2017.
 */
public class ExternalService {
    public void processOrder(Order order) throws OrderException{
        if (order.getQuantity() > 100 ) {
            throw new OrderException("Too much item for this order.");
        }

        //save somewhere...

    }
    public Order getOrderDetails(Integer orderID) throws OrderException {
        if(orderID == null || orderID < 100) {
            throw new OrderException("Could not find order details");

        }
        Order order = new Order();
        order.setItemId(orderID);
        order.setNote("aaa");
        order.setPrice(BigDecimal.TEN);
        return  order;
    }
}
