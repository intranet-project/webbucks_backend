package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.admin.dto.ReactMenuDto;
/**
 * @author 최유빈
 * @version 1.1 인트라넷 - 공홈 통신(인트라로부터 신규 메뉴 정보 가져오기)
 * @since 2024-07-08
 * */
public interface ReactMenuService {
	ArrayList<ReactMenuDto> selectMenu();
	ReactMenuDto updateMenu(Long menu_id,ReactMenuDto reactMenuDto);
	String getMenu(); // 1.1
}
