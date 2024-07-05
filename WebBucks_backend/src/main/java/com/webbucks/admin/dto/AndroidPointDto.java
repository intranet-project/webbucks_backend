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
public class AndroidPointDto {
	private long point_id;
    private long cust_id;
    private int points;
    private Date point_created_at;
    private Date point_update_at;
}
