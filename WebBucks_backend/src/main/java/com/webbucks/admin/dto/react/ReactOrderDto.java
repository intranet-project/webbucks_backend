package com.webbucks.admin.dto.react;

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
public class ReactOrderDto {
	private Long b_orderStatusId; // 상태ID
	private Long b_orderId; // 주문ID B_Order 내부
	private Long custId; // B_Order-> Customer 내부
	private String menuName; //메뉴명
	private String b_orderCreatedAt;	// 주문 일자
	private String b_orderStateUpdateAt; // 주문 상태 업데이트 일자
	private String b_orderState; // 주문 상태
}
