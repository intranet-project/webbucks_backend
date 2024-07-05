package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.B_Order;
import com.webbucks.Entity.Menu;
import com.webbucks.Entity.OrderItem;
import com.webbucks.Entity.Store;
import com.webbucks.Repository.OrderItemRepository;
import com.webbucks.admin.dto.AndroidOrderItemDto;

@Service
public class AndroidOrderItemServiceImpl implements AndroidOrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public ArrayList<AndroidOrderItemDto> saveOrderItems(ArrayList<AndroidOrderItemDto> androidOrderItemDto) {
        ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();
        OrderItem orderItem = new OrderItem();
        Store store = new Store(); 
    	B_Order order = new B_Order();
    	Menu menu = new Menu();
    	for(int i=0; i<androidOrderItemDto.size(); i++) {
    		System.out.println("장바구니확인용 : "+ androidOrderItemDto);
    		store.setStoreId(androidOrderItemDto.get(i).getStore_id());
    		order.setB_orderId(androidOrderItemDto.get(i).getOrder_id());
    		menu.setMenuId(androidOrderItemDto.get(i).getMenu_id());
    		
    		orderItem.setOrderItemId(androidOrderItemDto.get(i).getOrder_item_id());
    		orderItem.setOrder(order);
    		orderItem.setMenu(menu);
    		orderItem.setStore(store);
    		orderItem.setOrderItemQuantity(androidOrderItemDto.get(i).getItem_quantity());
    		orderList.add(orderItem);
    	}
    	
    	orderItemRepository.saveAll(orderList);
    	return androidOrderItemDto;
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderItem(Long id) {
    	orderItemRepository.deleteById(id);
    }
}
