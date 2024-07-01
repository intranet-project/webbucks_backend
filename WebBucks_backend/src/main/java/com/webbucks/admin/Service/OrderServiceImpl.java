package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webbucks.Entity.B_OrderState;
import com.webbucks.Repository.B_OrderStateRepository;
import com.webbucks.admin.dto.react.ReactOrderDto;

@Service
public class OrderServiceImpl implements OrderService {
	private final B_OrderStateRepository b_OrderStateRepository;
	
	public OrderServiceImpl(B_OrderStateRepository b_OrderStateRepository) {
		this.b_OrderStateRepository = b_OrderStateRepository;
	}

	@Override
	public ArrayList<ReactOrderDto> selectOrder(Long store_id) {
		List<ReactOrderDto> orderData = b_OrderStateRepository.findByOrderStoreStoreId(store_id).stream()
				.map(order -> ReactOrderDto.builder()
				.b_orderStatusId(order.getB_orderStatusId())
				.order(order.getOrder())
				.b_orderState(order.getB_orderState())
				.b_orderStateUpdateAt(order.getB_orderStateUpdateAt())
				.build())
				.collect(Collectors.toList());

		return (ArrayList<ReactOrderDto>) orderData;
	}

	@Override
	public ReactOrderDto updateOrder(Long order_status_id, ReactOrderDto reactOrderDto) {
			B_OrderState b_orderState = new B_OrderState( );
			b_orderState.setB_orderStatusId(reactOrderDto.getB_orderStatusId());
			b_orderState.setOrder(reactOrderDto.getOrder());
			b_orderState.setB_orderState(reactOrderDto.getB_orderState());
			b_orderState.setB_orderStateUpdateAt(reactOrderDto.getB_orderStateUpdateAt());
			b_OrderStateRepository.save(b_orderState);
			return reactOrderDto;
	}
	
	
}
