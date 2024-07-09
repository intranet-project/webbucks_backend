package com.webbucks.admin.dto;

import java.util.Date;

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
public class IntraSalesDto {
    private Long storeId;	// 매장ID
    private Long salesAmount;	// 금액
    private Date salesPri;	// 주문 일자
}
