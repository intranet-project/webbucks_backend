package com.webbucks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbucks.Entity.B_Order;

/**
 * 주문관리 테이블(B_Order) 엔티티의 레포지토리
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

public interface B_OrderRepository extends JpaRepository<B_Order, Long>{

}

