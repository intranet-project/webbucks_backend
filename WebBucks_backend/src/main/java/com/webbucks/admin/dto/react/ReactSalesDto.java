package com.webbucks.admin.dto.react;

import java.util.Date;

import com.webbucks.Entity.Customer;
import com.webbucks.Entity.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReactSalesDto {
    private Long b_orderId; // 주문ID
    private Customer customer;	// 고객ID
    private Store store;	// 매장ID   
    private double b_orderTotalAmount;	// 총 주문 금액
    private int b_orderPointsUsed;	// 사용된 포인트 
    private String b_orderState;	// 주문 상태
    private Date b_orderCreatedAt;	// 주문 일자
}
