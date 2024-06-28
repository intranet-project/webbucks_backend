package com.webbucks.admin.dto.react;

import com.webbucks.Entity.Category;
import com.webbucks.Entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReactMenuDto {
	private Long menuId; // 메뉴ID
	private String menuName; // 메뉴명
	private Category category; // 카테고리
	private double menuPrice; // 가격
	private String menuDetail; // 메뉴 상세
	private char soldoutState; // 품절여부
	private String menuImg; // 메뉴이미지
	
	
	public ReactMenuDto listMenu(Menu menu) {
		this.menuId = menu.getMenuId();
		this.menuName = menu.getMenuName();
		this.category = menu.getCategory();
		this.menuPrice = menu.getMenuPrice();
		this.menuDetail = menu.getMenuDetail();
		this.soldoutState = menu.getSoldoutState();
		this.menuImg = menu.getMenuImg();
		return this;
	}
}
