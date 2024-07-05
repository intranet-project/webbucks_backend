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
public class AndroidOrderDto {
	private long order_id;
    private long cust_id;
    private long store_id;
    private String store_name;
    private long menu_id;
    private String menu_name;
    private double order_total_amount;
    private int order_quantity;
    private int order_points_used;
    private String order_status;
    private Date order_created_at;
}
