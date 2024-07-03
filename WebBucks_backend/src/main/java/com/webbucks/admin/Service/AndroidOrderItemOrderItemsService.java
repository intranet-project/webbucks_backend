package com.webbucks.admin.Service;

import java.util.List;

import com.webbucks.Entity.OrderItem;

public interface AndroidOrderItemOrderItemsService {
    List<OrderItem> getAllOrderItems();
    OrderItem saveOrderItem(OrderItem orderItem);
    List<OrderItem> saveOrderItems(List<OrderItem> OrderItem);
    OrderItem getOrderItemById(Long id);
    void deleteOrderItem(Long id);
}
