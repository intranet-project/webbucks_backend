package com.webbucks.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.Entity.B_Order;
import com.webbucks.admin.Service.AndroidOrderService;

@RestController
@RequestMapping("/api/orders")
public class AndroidOrderController {

    @Autowired
    private AndroidOrderService ordersService;

    @GetMapping
    public List<B_Order> getAllOrders() {
        return ordersService.getAllOrders();
    }
    
    @PostMapping
    public B_Order saveOrder(@RequestBody B_Order order) {
        return ordersService.saveOrder(order);
    }
}
