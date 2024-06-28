package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webbucks.Repository.MenuRepository;
import com.webbucks.admin.dto.react.ReactMenuDto;

@Service
public class MenuServiceImpl implements MenuService {

	private final MenuRepository menuRepository;
	
	public MenuServiceImpl(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public ArrayList<ReactMenuDto> selectMenu() {
		List<ReactMenuDto> menuData = menuRepository.findAll().stream()
				.map(menu -> ReactMenuDto.builder().menuId(menu.getMenuId()).menuName(menu.getMenuName())
						.category(menu.getCategory()).menuPrice(menu.getMenuPrice()).menuDetail(menu.getMenuDetail())
						.soldoutState(menu.getSoldoutState()).menuImg(menu.getMenuImg()).build())
				.collect(Collectors.toList());

		return (ArrayList<ReactMenuDto>) menuData;
	}
	
	
	
}
