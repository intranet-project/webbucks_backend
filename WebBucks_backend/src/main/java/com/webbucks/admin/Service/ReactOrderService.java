package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.admin.dto.react.ReactOrderDto;

public interface ReactOrderService {
	ArrayList<ReactOrderDto> selectOrder(Long store_id);
	ReactOrderDto updateOrder(Long store_id, ReactOrderDto reactOrderDto);
}
 