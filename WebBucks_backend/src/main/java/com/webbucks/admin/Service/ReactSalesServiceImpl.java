package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webbucks.Entity.Sales;
import com.webbucks.Repository.B_OrderRepository;
import com.webbucks.Repository.SaleRepository;
import com.webbucks.admin.dto.IntraSalesDto;
import com.webbucks.admin.dto.ReactSalesDto;
import com.webbucks.admin.dto.ReactTotalSalesDto;

@Service
public class ReactSalesServiceImpl implements ReactSalesService {

	private final SaleRepository saleRepository;
	private final B_OrderRepository b_orderRepository;
	public ReactSalesServiceImpl(SaleRepository saleRepository, B_OrderRepository b_orderRepository) {

		this.saleRepository = saleRepository;
		this.b_orderRepository = b_orderRepository;
	}

	@Override
	public ReactTotalSalesDto selectSales(Long store_id) {
		Sales sales =  saleRepository.findByStoreStoreId(store_id);
		long totalSales = b_orderRepository.getTotalSales(store_id);
		sales.setSaleTotalAmount(totalSales);
		saleRepository.save(sales);
		
		ReactTotalSalesDto salesData = new ReactTotalSalesDto();
		salesData.setSalesId(sales.getSalesId());
		salesData.setStoreId(sales.getStore().getStoreId());
		salesData.setSalesTotalAmount(sales.getSaleTotalAmount());
		
    	return salesData;
	}

	@Override
	public ReactSalesDto updateTotalSales(Long store_id, ReactSalesDto reactSalesDto) {
		Sales sales = new Sales();
		sales = (Sales) saleRepository.findByStoreStoreId(store_id);
		sales.setSaleTotalAmount(sales.getSaleTotalAmount()+(long)reactSalesDto.getOrderPointsUsed());
		saleRepository.save(sales);
		return reactSalesDto;
	}

	@Override
	public ArrayList<IntraSalesDto> selectTotalSales(Long store_id) {
		List<IntraSalesDto> salesData = b_orderRepository.findByStoreStoreId(store_id).stream()
				.map(order -> IntraSalesDto.builder()
						.storeId(order.getStore().getStoreId())
						.salesAmount((long)order.getOrderPointsUsed())
						.salesPri(order.getOrderCreatedAt()).build())
				.collect(Collectors.toList());
        return (ArrayList<IntraSalesDto>) salesData;
	}


	
}
