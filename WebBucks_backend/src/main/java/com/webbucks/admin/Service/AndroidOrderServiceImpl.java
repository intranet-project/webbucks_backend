package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.B_Order;
import com.webbucks.Entity.B_OrderState;
import com.webbucks.Entity.Customer;
import com.webbucks.Entity.Menu;
import com.webbucks.Entity.Sales;
import com.webbucks.Entity.Store;
import com.webbucks.Repository.B_OrderRepository;
import com.webbucks.Repository.B_OrderStateRepository;
import com.webbucks.Repository.SaleRepository;
import com.webbucks.admin.dto.AndroidOrderDto;

@Service
public class AndroidOrderServiceImpl implements AndroidOrderService {

    @Autowired
    private B_OrderRepository b_orderRepository;
    
    @Autowired
    private SaleRepository saleRepository;
    
    @Autowired
    private B_OrderStateRepository b_orderStateRepository;
    
    @Override
    public ArrayList<AndroidOrderDto> getAllOrders() {
    	List<AndroidOrderDto> orderData = b_orderRepository.findAll().stream()
				.map(order -> AndroidOrderDto.builder()
						.order_id(order.getB_orderId())
						.cust_id(order.getCustomer().getCustId())
						.store_id(order.getStore().getStoreId())
						.store_name(order.getStore().getStoreName())
						.menu_id(order.getMenu().getMenuId())
						.menu_name(order.getMenu().getMenuName())
						.order_quantity(order.getOrder_quantity())
						.order_total_amount(order.getOrderPointsUsed())
						.order_points_used(order.getOrderPointsUsed())
						.order_status(order.getOrderState())
						.order_created_at(order.getOrderCreatedAt()).build())
				.collect(Collectors.toList());
        return (ArrayList<AndroidOrderDto>) orderData;
    }

    @Override
    public B_Order getOrderById(Long id) {
        return b_orderRepository.findById(id).orElse(null);
    }

    @Override
    public AndroidOrderDto saveOrder(AndroidOrderDto androidOrderDto) {
    	B_Order order = new B_Order(); 
    	B_OrderState orderState = new B_OrderState();
    	Store store = new Store(); 
    	Customer customer = new Customer();
    	Menu menu = new Menu();
    	
    	menu.setMenuId(androidOrderDto.getMenu_id() == 0 ? null: androidOrderDto.getMenu_id());
    	customer.setCustId(androidOrderDto.getCust_id());
    	store.setStoreId(androidOrderDto.getStore_id());
    	
    	 
    	
    	order.setMenu(menu);
    	order.setCustomer(customer);
    	order.setStore(store);
    	order.setOrder_quantity(androidOrderDto.getOrder_quantity());
    	order.setOrderPointsUsed(androidOrderDto.getOrder_points_used());
    	order.setOrderState(androidOrderDto.getOrder_status());
    	order.setOrderCreatedAt(androidOrderDto.getOrder_created_at());
    	
    	Date now = new Date();
    	orderState.setOrder(order);
    	orderState.setB_orderState(order.getOrderState());
    	orderState.setB_orderStateUpdateAt(now);
    	b_orderRepository.save(order);
    	b_orderStateRepository.save(orderState);
    	
    	Sales sales =  saleRepository.findByStoreStoreId(androidOrderDto.getStore_id());
    	sales.setSaleTotalAmount(sales.getSaleTotalAmount()+(long)androidOrderDto.getOrder_points_used());
    	saleRepository.save(sales);
        return androidOrderDto;
    }

    @Override
    public void deleteOrder(Long id) {
    	b_orderRepository.deleteById(id);
    }
}
