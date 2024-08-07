package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.admin.dto.ReactOrderDto;
import com.webbucks.admin.dto.ReactSalesDto;

public interface ReactOrderService {
	ArrayList<ReactOrderDto> selectOrder(Long store_id);
	ReactOrderDto updateOrder(Long store_id, ReactOrderDto reactOrderDto);
	ReactOrderDto selectRecentOrder(Long cust_id);
	ArrayList<ReactSalesDto> SalesList(Long store_id);
}
 