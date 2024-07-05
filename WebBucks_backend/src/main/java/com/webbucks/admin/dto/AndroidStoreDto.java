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
public class AndroidStoreDto {
	private long store_id;
    private String store_name;
    private String store_address;
    private double store_latitude;
    private double store_longitude;
    private boolean isFavorite;
}
