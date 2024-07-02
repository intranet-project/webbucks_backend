package com.webbucks.admin.Controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.admin.Service.OrderService;
import com.webbucks.admin.dto.react.ReactOrderDto;

@RestController
@RequestMapping(value = "/api/v1")
public class OrderController {
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/b_order/list/{store_id}")
    public ResponseEntity<ArrayList<ReactOrderDto>> listMenu(@PathVariable("store_id") Long store_id) {
        return new ResponseEntity<ArrayList<ReactOrderDto>>(orderService.selectOrder(store_id), HttpStatus.OK); 
    }
	
	@PutMapping("/b_order/orderState/{order_status_id}")
    public ResponseEntity<ReactOrderDto> updateMenu(@PathVariable("order_status_id") Long order_status_id, @RequestBody ReactOrderDto reactOrderDto) {
        return new ResponseEntity<ReactOrderDto>(orderService.updateOrder(order_status_id,reactOrderDto), HttpStatus.OK); // 200 응답
    }
}
