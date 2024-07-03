package com.webbucks.admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.OrderItem;
import com.webbucks.Repository.OrderItemRepository;

@Service
public class AndroidOrderItemServiceImpl implements AndroidOrderItemOrderItemsService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> saveOrderItems(List<OrderItem> orderItem) {
        return orderItemRepository.saveAll(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderItem(Long id) {
    	orderItemRepository.deleteById(id);
    }
}
