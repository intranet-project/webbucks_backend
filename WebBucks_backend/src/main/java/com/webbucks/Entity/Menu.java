package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 메뉴 테이블(Menu) 엔티티로, 메뉴에 대한 내용을 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Menu")
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Long menuId; // 메뉴ID

	@Column(name = "menu_name", nullable = false)
	private String menuName; // 메뉴명

	@Column(name = "menu_category", nullable = false)
	private String menuCategory; // 카테고리

	@Column(name = "menu_price", nullable = false)
	private double menuPrice; // 가격

	@Column(name = "menu_detail", nullable = true, columnDefinition = "TEXT")
	private String menuDetail; // 메뉴 상세

	@Column(name = "soldout_state", nullable = false, length = 1)
	private char soldoutState; // 품절여부

	@Column(name = "menu_img", nullable = false, length = 255)
	private char menuImg; // 메뉴이미지
	
	

	
}