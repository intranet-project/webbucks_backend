package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.admin.dto.ReactSalesDto;

public interface ReactSalesService {
	ArrayList<ReactSalesDto> selectSales(Long store_id);
	ReactSalesDto updateTotalSales(Long store_id, ReactSalesDto reactSalesDto);
}
