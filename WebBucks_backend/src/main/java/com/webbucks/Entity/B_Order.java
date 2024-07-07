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
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu; // 메뉴ID

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;	// 고객ID
    
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;	// 매장ID   
    
    @Column(name = "order_quantity", nullable = false)
    private int order_quantity;	// 주문 수량
    
    @Column(name = "b_order_points_used", nullable = true)
    private int orderPointsUsed;	// 사용된 포인트 
    
    @Column(name = "b_order_state", nullable = false)
    private String orderState;	// 주문 상태
    
    @Column(name = "b_order_created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderCreatedAt;	// 주문 일자
    
    
}

