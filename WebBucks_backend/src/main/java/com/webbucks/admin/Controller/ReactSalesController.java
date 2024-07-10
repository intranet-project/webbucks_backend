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
import com.webbucks.admin.Service.ReactSalesService;
import com.webbucks.admin.dto.IntraSalesDto;
import com.webbucks.admin.dto.ReactSalesDto;
import com.webbucks.admin.dto.ReactTotalSalesDto;

@RestController
@RequestMapping(value = "/api/v1")
public class ReactSalesController {
	private final ReactSalesService salesService;
	private final ReactOrderService orderService;
	
	public ReactSalesController(ReactSalesService salesService, ReactOrderService orderService) {
		this.salesService = salesService;
		this.orderService = orderService;
	}
	
	@GetMapping("/sales/totalSales")
    public ResponseEntity<ReactTotalSalesDto> listSales() {
        return new ResponseEntity<ReactTotalSalesDto>(salesService.selectSales((long)1), HttpStatus.OK); 
    }
	
	@GetMapping("/sales/listOrder")
    public ResponseEntity<ArrayList<ReactSalesDto>> orderSales() {
        return new ResponseEntity<ArrayList<ReactSalesDto>>(orderService.SalesList((long)1), HttpStatus.OK); 
    }
	
	//안드로이드와 api통신 떄 사용해야하는듯
	@PutMapping("/sales/totalsales/{store_id}") 
    public ResponseEntity<ReactSalesDto> updateSales(@PathVariable("store_id") Long store_id, @RequestBody ReactSalesDto reactSalesDto) {
        return new ResponseEntity<ReactSalesDto>(salesService.updateTotalSales(store_id,reactSalesDto), HttpStatus.OK); // 200 응답
    }
	
	
	@GetMapping("/sales") 
    public ResponseEntity<ArrayList<IntraSalesDto>> listTotalSales() {
		
        return new ResponseEntity<ArrayList<IntraSalesDto>>(salesService.selectTotalSales(), HttpStatus.OK);
    }
}
