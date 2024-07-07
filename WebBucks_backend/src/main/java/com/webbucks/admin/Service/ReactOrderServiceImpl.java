package com.webbucks.admin.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webbucks.Entity.B_Order;
import com.webbucks.Entity.B_OrderState;
import com.webbucks.Repository.B_OrderRepository;
import com.webbucks.Repository.B_OrderStateRepository;
import com.webbucks.admin.dto.ReactOrderDto;
import com.webbucks.admin.dto.ReactSalesDto;

@Service
public class ReactOrderServiceImpl implements ReactOrderService {
	
	private final B_OrderRepository b_OrderRepository;
	private final B_OrderStateRepository b_OrderStateRepository;
	
	public ReactOrderServiceImpl(B_OrderStateRepository b_OrderStateRepository, B_OrderRepository b_OrderRepository) {
		this.b_OrderStateRepository = b_OrderStateRepository;
		this.b_OrderRepository = b_OrderRepository;
	}
	
	@Override
	public ArrayList<ReactOrderDto> selectOrder(Long store_id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		List<ReactOrderDto> orderData = b_OrderStateRepository.findByOrderStoreStoreId(store_id).stream()
				.map(order -> ReactOrderDto.builder()
				.b_orderStatusId(order.getB_orderStatusId())
				.b_orderId(order.getOrder().getB_orderId())
				.custId(order.getOrder().getCustomer().getCustId())
				.menuName(order.getOrder().getMenu().getMenuName())
				.b_orderCreatedAt(sdf.format(order.getOrder().getOrderCreatedAt()))
				.b_orderStateUpdateAt(sdf.format(order.getB_orderStateUpdateAt()))
				.b_orderState(order.getB_orderState())
				.build())
				.collect(Collectors.toList());
		
		return (ArrayList<ReactOrderDto>) orderData;
	}

	@Override
	public ReactOrderDto updateOrder(Long order_status_id, ReactOrderDto reactOrderDto) {
			B_OrderState b_orderState = b_OrderStateRepository.findById(order_status_id)
					.orElseThrow();
			B_Order b_order = b_OrderRepository.findById(reactOrderDto.getB_orderId())
					.orElseThrow();
			
			Date now = new Date();
			b_orderState.setB_orderState(reactOrderDto.getB_orderState());
			b_orderState.setB_orderStateUpdateAt(now);
			b_order.setOrderState(reactOrderDto.getB_orderState());
			b_OrderStateRepository.save(b_orderState);
			b_OrderRepository.save(b_order);
			return reactOrderDto;
	}

	@Override
	public ArrayList<ReactSalesDto> SalesList(Long store_id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		List<ReactSalesDto> orderData = b_OrderRepository.findByStoreStoreIdAndOrderState(store_id, "완료").stream()
				.map(order -> ReactSalesDto.builder()
						.orderId(order.getB_orderId())
						.storeId(order.getStore().getStoreId())
						.categoryId(order.getMenu().getCategory().getCategoryId())
						.categoryname(order.getMenu().getCategory().getCategoryname())
						.orderPointsUsed(order.getOrderPointsUsed())
						.orderCreatedAt(sdf.format(order.getOrderCreatedAt()))
				.build())
				.collect(Collectors.toList());
		
		return (ArrayList<ReactSalesDto>) orderData;
	}

}