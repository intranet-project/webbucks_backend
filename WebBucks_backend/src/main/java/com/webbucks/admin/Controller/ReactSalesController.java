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

import com.webbucks.admin.Service.ReactSalesService;
import com.webbucks.admin.dto.react.ReactSalesDto;

@RestController
@RequestMapping(value = "/api/v1")
public class ReactSalesController {
	private final ReactSalesService salesService;
	
	public ReactSalesController(ReactSalesService salesService) {
		this.salesService = salesService;
	}
	
	@GetMapping("/sales/list")
    public ResponseEntity<ArrayList<ReactSalesDto>> listSales() {
        return new ResponseEntity<ArrayList<ReactSalesDto>>(salesService.selectSales((long)1), HttpStatus.OK); 
    }
	
	//안드로이드와 api통신 떄 사용해야하는듯
	@PutMapping("/sales/totalsales/{store_id}") 
    public ResponseEntity<ReactSalesDto> updateSales(@PathVariable("store_id") Long store_id, @RequestBody ReactSalesDto reactSalesDto) {
        return new ResponseEntity<ReactSalesDto>(salesService.updateTotalSales(store_id,reactSalesDto), HttpStatus.OK); // 200 응답
    }
}