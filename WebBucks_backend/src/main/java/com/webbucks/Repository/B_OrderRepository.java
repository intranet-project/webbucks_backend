package com.webbucks.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webbucks.Entity.B_Order;

/**
 * 주문관리 테이블(B_Order) 엔티티의 레포지토리
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

public interface B_OrderRepository extends JpaRepository<B_Order, Long>{
	public List<B_Order> findByStoreStoreId(Long store_Id);
	public List<B_Order> findByStoreStoreIdAndOrderState(Long store_Id, String orderState);
	public List<B_Order> findByCustomerCustIdOrderByOrderCreatedAtDesc(Long cust_Id);
	@Query("SELECT SUM(o.orderPointsUsed) FROM B_Order o WHERE o.orderState != '취소' AND o.store.storeId = :storeId")
    Long getTotalSales(@Param("storeId") Long storeId);
}

