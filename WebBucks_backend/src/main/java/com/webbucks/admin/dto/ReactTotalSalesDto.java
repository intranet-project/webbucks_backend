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
public class ReactTotalSalesDto {
	private Long salesId; //매출 ID
	private Long storeId; // 매장 ID
	private Long saleTotalAmount;
}
