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

import com.webbucks.admin.Service.ReactOrderService;
import com.webbucks.admin.dto.ReactOrderDto;

@RestController
@RequestMapping(value = "/api/v1")
public class ReactOrderController {
	private final ReactOrderService orderService;
	
	public ReactOrderController(ReactOrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/b_order/list")
    public ResponseEntity<ArrayList<ReactOrderDto>> listOrder() {
        return new ResponseEntity<ArrayList<ReactOrderDto>>(orderService.selectOrder((long)1), HttpStatus.OK); 
    }
	
	@PutMapping("/b_order/orderState/{order_status_id}")
    public ResponseEntity<ReactOrderDto> updateOrder(@PathVariable("order_status_id") Long order_status_id, @RequestBody ReactOrderDto reactOrderDto) {
        return new ResponseEntity<ReactOrderDto>(orderService.updateOrder(order_status_id,reactOrderDto), HttpStatus.OK); // 200 응답
    }
}
