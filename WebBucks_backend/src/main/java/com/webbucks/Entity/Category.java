package com.webbucks.Entity;

import lombok.Data;
import javax.persistence.*;

/**
 * 카테고리 테이블(Category) 엔티티로, 메뉴에 대한 카테고리 내용을 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId; // 카테고리ID

    @Column(name = "category_name", nullable = false)
    private String categoryname; // 카테고리명

    }