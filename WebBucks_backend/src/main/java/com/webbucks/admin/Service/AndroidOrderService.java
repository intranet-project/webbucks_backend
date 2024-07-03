package com.webbucks.admin.Service;

import java.util.List;

import com.webbucks.Entity.B_Order;

public interface AndroidOrderService {
    List<B_Order> getAllOrders();
    B_Order getOrderById(Long id);
    B_Order saveOrder(B_Order order);
    void deleteOrder(Long id);
}
