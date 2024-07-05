package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;

import com.webbucks.Entity.OrderItem;
import com.webbucks.admin.dto.AndroidOrderItemDto;

public interface AndroidOrderItemService {
    List<OrderItem> getAllOrderItems();
    OrderItem saveOrderItem(OrderItem orderItem);
    ArrayList<AndroidOrderItemDto> saveOrderItems(ArrayList<AndroidOrderItemDto> androidOrderItemDto);
    OrderItem getOrderItemById(Long id);
    void deleteOrderItem(Long id);
}
