package com.webbucks.admin.Service;

import com.webbucks.admin.dto.ReactSalesDto;
import com.webbucks.admin.dto.ReactTotalSalesDto;

public interface ReactSalesService {
	ReactTotalSalesDto selectSales(Long store_id);
	ReactSalesDto updateTotalSales(Long store_id, ReactSalesDto reactSalesDto);
}
