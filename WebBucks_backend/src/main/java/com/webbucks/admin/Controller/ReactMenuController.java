package com.webbucks.admin.Controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webbucks.admin.Service.ReactMenuService;
import com.webbucks.admin.dto.ReactMenuDto;

@RestController
@RequestMapping(value = "/api/v1")
public class ReactMenuController {

	private final ReactMenuService menuService;

	public ReactMenuController(ReactMenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping("/menu/list")
    public ResponseEntity<ArrayList<ReactMenuDto>> listMenu() {
        return new ResponseEntity<ArrayList<ReactMenuDto>>(menuService.selectMenu(), HttpStatus.OK); 
    }

	@PutMapping("/menu/soldout/{menu_id}")
    public ResponseEntity<ReactMenuDto> updateMenu(@PathVariable("menu_id") Long menu_id, @RequestBody ReactMenuDto reactMenuDto) {
        System.out.println("id : "+menu_id);
		return new ResponseEntity<ReactMenuDto>(menuService.updateMenu(menu_id,reactMenuDto), HttpStatus.OK); // 200 응답
    }
	
	
	
}

