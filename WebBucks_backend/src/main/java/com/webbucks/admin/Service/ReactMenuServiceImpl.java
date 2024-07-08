package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.webbucks.Entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Menu;
import com.webbucks.Repository.MenuRepository;
import com.webbucks.admin.dto.ReactMenuDto;
import org.springframework.web.client.RestTemplate;

@Service
public class ReactMenuServiceImpl implements ReactMenuService {

	private final MenuRepository menuRepository;

	@Autowired
	private RestTemplate restTemplate; // 1.1
	
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

	// 1.1
	@Override
	public String getMenu() {
		String url= "http://localhost:9000/api/v1/intrabucks/menu/getmenu";
		// GET 요청 보내기
		ResponseEntity<List<Menu>> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Menu>>() {}
		);
		List<Menu> menus = response.getBody();
		menuRepository.saveAll(menus);
		return "success";
	}


}
