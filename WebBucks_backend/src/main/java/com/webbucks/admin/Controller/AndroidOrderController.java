package com.webbucks.admin.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.Entity.B_Order;
import com.webbucks.admin.Service.AndroidOrderService;
import com.webbucks.admin.dto.AndroidOrderDto;

@RestController
@RequestMapping("/api/orders")
public class AndroidOrderController {

    @Autowired
    private AndroidOrderService ordersService;

    @GetMapping
    public  ResponseEntity<ArrayList<AndroidOrderDto>> getAllOrders() {
    	return ResponseEntity.ok(ordersService.getAllOrders());
    }
    @PostMapping
    public AndroidOrderDto saveOrder(@RequestBody AndroidOrderDto androidOrderDto) {
        return ordersService.saveOrder(androidOrderDto);
    }
}
