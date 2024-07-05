package com.webbucks.admin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.Entity.OrderItem;
import com.webbucks.admin.Service.AndroidOrderItemService;
import com.webbucks.admin.dto.AndroidOrderItemDto;

@RestController
@RequestMapping("/api/order-items")
public class AndroidOrderItemController {

    @Autowired
    private AndroidOrderItemService orderItemsService;

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemsService.getAllOrderItems();
    }

    @PostMapping
    public OrderItem saveOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemsService.saveOrderItem(orderItem);
    }

    @PostMapping("/batch")
    public ResponseEntity<ArrayList<AndroidOrderItemDto>> saveOrderItems(@RequestBody ArrayList<AndroidOrderItemDto> androidOrderItemDto) {
        try {
            return ResponseEntity.ok(orderItemsService.saveOrderItems(androidOrderItemDto));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
    	OrderItem orderItem = orderItemsService.getOrderItemById(id);
        return orderItem != null ? ResponseEntity.ok(orderItem) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemsService.deleteOrderItem(id);
    }
}
