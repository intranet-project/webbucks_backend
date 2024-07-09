package com.webbucks.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

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
	@JsonProperty("order_id") // JSON 직렬화/역직렬화 시 사용할 필드 이름 매핑
    @Column(name = "b_order_id")
    private Long b_orderId; // 주문ID
    
	@ManyToOne
    @JoinColumn(name = "menu_id", nullable = true)
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

