package com.webbucks.admin.Service;

import java.util.List;

import com.webbucks.Entity.Menu;

public interface AndroidMenuService {
    List<Menu> getAllMenus();
    Menu getMenuById(Long id);
    Menu saveMenu(Menu menu);
    void deleteMenu(Long id);
}
