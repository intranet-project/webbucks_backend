package com.webbucks.admin.dto;

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
    private Long orderId; // 주문ID
    private Long storeId;	// 매장ID
    private Long categoryId; // 카테고리
	private String categoryname; // 카테고리명
    private int orderPointsUsed;	// 사용된 포인트
    private String orderCreatedAt;	// 주문 일자
}