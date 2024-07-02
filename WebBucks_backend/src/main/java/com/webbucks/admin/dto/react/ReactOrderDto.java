package com.webbucks.admin.dto.react;

import java.util.Date;

import com.webbucks.Entity.B_Order;

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
	private B_Order order; // 주문ID
	private String b_orderState; // 주문 상태
	private Date b_orderStateUpdateAt; // 주문 상태 업데이트 일자
	
}
