package com.webbucks.admin.dto;

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
	private Long categoryId; // 카테고리
	private String categoryname; // 카테고리명
	private double menuPrice; // 가격
	private String menuDetail; // 메뉴 상세
	private char soldoutState; // 품절여부
	private String menuImg; // 메뉴이미지
}
