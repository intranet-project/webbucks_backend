package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.admin.dto.IntraSalesDto;
import com.webbucks.admin.dto.ReactSalesDto;
import com.webbucks.admin.dto.ReactTotalSalesDto;

public interface ReactSalesService {
	ReactTotalSalesDto selectSales(Long store_id);
	ReactSalesDto updateTotalSales(Long store_id, ReactSalesDto reactSalesDto);
	ArrayList<IntraSalesDto> selectTotalSales(Long store_id);
}
