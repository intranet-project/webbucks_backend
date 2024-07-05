package com.webbucks.admin.Service;

import java.util.ArrayList;

import com.webbucks.Entity.Menu;
import com.webbucks.admin.dto.AndroidMenuDto;

public interface AndroidMenuService {
	ArrayList<AndroidMenuDto> getAllMenus();
    Menu getMenuById(Long id);
    Menu saveMenu(Menu menu);
    void deleteMenu(Long id);
}
