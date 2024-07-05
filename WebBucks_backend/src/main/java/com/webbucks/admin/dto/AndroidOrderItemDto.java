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
public class AndroidOrderItemDto {
	private long order_item_id;
	private long order_id;
	private long cust_id;
	private long store_id;
	private String store_name;
	private long menu_id;
	private String menu_name;
	private int item_quantity;
	private int item_price;
	private Date order_date;
}
