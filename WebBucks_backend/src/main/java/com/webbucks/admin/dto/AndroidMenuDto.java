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
public class AndroidMenuDto {
	private long menu_id;
    private String menu_name;
    private long category_id;
    private long menu_price;
    private String menu_detail;
    private char soldout_state;
}
