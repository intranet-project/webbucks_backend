package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webbucks.Entity.Sales;
import com.webbucks.Repository.B_OrderRepository;
import com.webbucks.Repository.SaleRepository;
import com.webbucks.admin.dto.react.ReactSalesDto;

@Service
public class SalesServiceImpl implements SalesService {
	
	private final B_OrderRepository b_OrderRepository;
	private final SaleRepository saleRepository;
	
	public SalesServiceImpl(B_OrderRepository b_OrderRepository, SaleRepository saleRepository) {
		this.b_OrderRepository = b_OrderRepository;
		this.saleRepository = saleRepository;
	}

	@Override
	public ArrayList<ReactSalesDto> selectSales(Long store_id) {
		List<ReactSalesDto> salesData = b_OrderRepository.findByStoreStoreId(store_id).stream()
				.map(sales -> ReactSalesDto.builder()
				.b_orderId(sales.getB_orderId())
				.customer(sales.getCustomer())
				.store(sales.getStore())
				.b_orderTotalAmount(sales.getB_orderTotalAmount())
				.b_orderPointsUsed(sales.getB_orderPointsUsed())
				.b_orderState(sales.getB_orderState())
				.b_orderCreatedAt(sales.getB_orderCreatedAt())
				.build())
				.collect(Collectors.toList());
		
		return (ArrayList<ReactSalesDto>) salesData;
	}

	@Override
	public ReactSalesDto updateTotalSales(Long store_id, ReactSalesDto reactSalesDto) {
		Sales sales = new Sales();
		sales = (Sales) saleRepository.findByStoreStoreId(store_id);
		sales.setSaleTotalAmount(sales.getSaleTotalAmount()+(long)reactSalesDto.getB_orderTotalAmount());
		saleRepository.save(sales);
		return reactSalesDto;
	}
	
}
