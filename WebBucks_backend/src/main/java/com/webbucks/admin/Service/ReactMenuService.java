package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.admin.dto.ReactMenuDto;

public interface ReactMenuService {
	ArrayList<ReactMenuDto> selectMenu();
	ReactMenuDto updateMenu(Long menu_id,ReactMenuDto reactMenuDto);
}
