package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;

/**
 * 주문관리 테이블(B_Order) 엔티티로, 주문테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "B_Order")
@Data
public class B_Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_order_id")
    private Long b_orderId; // 주문ID
    

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;	// 고객ID
    
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;	// 매장ID   
    
    @Column(name = "b_order_total_amount", nullable = false, precision = 10, scale = 2)
    private double b_orderTotalAmount;	// 총 주문 금액
    
    @Column(name = "b_order_points_used", nullable = true)
    private int b_orderPointsUsed;	// 사용된 포인트 
    
    @Column(name = "b_order_state", nullable = false)
    private String b_orderState;	// 주문 상태
    
    @Column(name = "b_order_created_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date b_orderCreatedAt;	// 주문 일자
    
    
}
