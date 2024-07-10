package com.webbucks.admin.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webbucks.Entity.B_Order;
import com.webbucks.Entity.B_OrderState;
import com.webbucks.Entity.Point;
import com.webbucks.Repository.B_OrderRepository;
import com.webbucks.Repository.B_OrderStateRepository;
import com.webbucks.Repository.PointRepository;
import com.webbucks.admin.dto.ReactOrderDto;
import com.webbucks.admin.dto.ReactSalesDto;

@Service
public class ReactOrderServiceImpl implements ReactOrderService {
	
	private final B_OrderRepository b_OrderRepository;
	private final B_OrderStateRepository b_OrderStateRepository;
	private final PointRepository pointRepository;
	
	public ReactOrderServiceImpl(B_OrderStateRepository b_OrderStateRepository,
									B_OrderRepository b_OrderRepository,
									PointRepository pointRepository) {
		this.b_OrderStateRepository = b_OrderStateRepository;
		this.b_OrderRepository = b_OrderRepository;
		this.pointRepository = pointRepository;
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
	public ReactOrderDto selectRecentOrder(Long cust_id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		List<B_Order> order =  b_OrderRepository.findByCustomerCustIdOrderByOrderCreatedAtDesc(cust_id);
		ReactOrderDto reactOrderDto = new ReactOrderDto();
		
		reactOrderDto.setB_orderId(order.get(0).getB_orderId());
		reactOrderDto.setCustId(order.get(0).getCustomer().getCustId());
		reactOrderDto.setB_orderCreatedAt(sdf.format(order.get(0).getOrderCreatedAt()));
		reactOrderDto.setMenuName(order.get(0).getMenu().getMenuName());
		
		return reactOrderDto;
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
			System.out.println("state : "+reactOrderDto.getB_orderState());
			if(reactOrderDto.getB_orderState().equals("취소") ) {
				Point point = pointRepository.findByCustomerCustId(reactOrderDto.getCustId());
				System.out.println("point "+point);
				point.setPoints(point.getPoints()+b_order.getOrderPointsUsed());
				pointRepository.save(point);
			}
			
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