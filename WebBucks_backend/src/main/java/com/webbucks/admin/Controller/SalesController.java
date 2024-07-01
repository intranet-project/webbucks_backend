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

import com.webbucks.admin.Service.SalesService;
import com.webbucks.admin.dto.react.ReactOrderDto;
import com.webbucks.admin.dto.react.ReactSalesDto;

@RestController
@RequestMapping(value = "/api/v1")
public class SalesController {
	private final SalesService salesService;
	
	public SalesController(SalesService salesService) {
		this.salesService = salesService;
	}
	
	@GetMapping("/sales/list/{store_id}")
    public ResponseEntity<ArrayList<ReactSalesDto>> listMenu(@PathVariable("store_id") Long store_id) {
        return new ResponseEntity<ArrayList<ReactSalesDto>>(salesService.selectSales(store_id), HttpStatus.OK); 
    }
	
	@PutMapping("/sales/totalsales/{store_id}")
    public ResponseEntity<ReactSalesDto> updateMenu(@PathVariable("store_id") Long store_id, @RequestBody ReactSalesDto reactSalesDto) {
        return new ResponseEntity<ReactSalesDto>(salesService.updateTotalSales(store_id,reactSalesDto), HttpStatus.OK); // 200 응답
    }
}
