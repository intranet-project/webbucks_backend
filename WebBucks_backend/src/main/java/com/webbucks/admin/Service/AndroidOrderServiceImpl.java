package com.webbucks.admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.B_Order;
import com.webbucks.Repository.B_OrderRepository;

@Service
public class AndroidOrderServiceImpl implements AndroidOrderService {

    @Autowired
    private B_OrderRepository b_orderRepository;

    @Override
    public List<B_Order> getAllOrders() {
        return b_orderRepository.findAll();
    }

    @Override
    public B_Order getOrderById(Long id) {
        return b_orderRepository.findById(id).orElse(null);
    }

    @Override
    public B_Order saveOrder(B_Order order) {
        return b_orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
    	b_orderRepository.deleteById(id);
    }
}
