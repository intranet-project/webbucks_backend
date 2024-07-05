package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.Entity.B_Order;
import com.webbucks.admin.dto.AndroidOrderDto;

public interface AndroidOrderService {
	ArrayList<AndroidOrderDto> getAllOrders();
    B_Order getOrderById(Long id);
    AndroidOrderDto saveOrder(AndroidOrderDto androidOrderDto);
    void deleteOrder(Long id);
}
