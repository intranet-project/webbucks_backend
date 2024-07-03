package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.webbucks.Entity.Menu;
import com.webbucks.Repository.MenuRepository;
import com.webbucks.admin.dto.react.ReactMenuDto;

@Service
public class ReactMenuServiceImpl implements ReactMenuService {

	private final MenuRepository menuRepository;
	
	public ReactMenuServiceImpl(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public ArrayList<ReactMenuDto> selectMenu() {
		List<ReactMenuDto> menuData = menuRepository.findAll().stream()
				.map(menu -> ReactMenuDto.builder()
						.menuId(menu.getMenuId())
						.menuName(menu.getMenuName())
						.categoryId(menu.getCategory().getCategoryId())
						.categoryname(menu.getCategory().getCategoryname())
						.menuPrice(menu.getMenuPrice())
						.menuDetail(menu.getMenuDetail())
						.soldoutState(menu.getSoldoutState())
						.menuImg(menu.getMenuImg()).build())
				.collect(Collectors.toList());

		return (ArrayList<ReactMenuDto>) menuData;
	}

	@Override
	public ReactMenuDto updateMenu(Long menu_id,ReactMenuDto reactMenuDto) {
		 Menu menu = menuRepository.findById(menu_id)
                 .orElseThrow();
		menu.setSoldoutState(reactMenuDto.getSoldoutState());
		menuRepository.save(menu);
		return reactMenuDto;
	}
	
	
	
}
