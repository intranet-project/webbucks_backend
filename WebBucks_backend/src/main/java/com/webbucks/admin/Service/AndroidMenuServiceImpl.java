package com.webbucks.admin.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbucks.Entity.Menu;
import com.webbucks.Repository.MenuRepository;
import com.webbucks.admin.dto.AndroidMenuDto;

@Service
public class AndroidMenuServiceImpl implements AndroidMenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public ArrayList<AndroidMenuDto> getAllMenus() {
    	List<AndroidMenuDto> menuData = menuRepository.findAll().stream()
				.map(menu -> AndroidMenuDto.builder()
						.menu_id(menu.getMenuId())
						.menu_name(menu.getMenuName())
						.category_id((int)menu.getCategory().getCategoryId())
						.menu_price((int)menu.getMenuPrice())
						.menu_detail(menu.getMenuDetail())
						.soldout_state(menu.getSoldoutState()).build())
				.collect(Collectors.toList());
        return (ArrayList<AndroidMenuDto>) menuData;
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
