package com.webbucks.admin.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.Entity.Menu;
import com.webbucks.admin.Service.AndroidMenuService;
import com.webbucks.admin.dto.AndroidMenuDto;

@RestController
@RequestMapping("/api/menu")
public class AndroidMenuController {

    @Autowired
    private AndroidMenuService menuService;

    @GetMapping
    public ResponseEntity<ArrayList<AndroidMenuDto>>  getAllMenus() {
    	return new ResponseEntity<ArrayList<AndroidMenuDto>>(menuService.getAllMenus(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping
    public Menu saveMenu(@RequestBody Menu menu) {
        return menuService.saveMenu(menu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
