package com.webbucks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbucks.Entity.Sales;

/**
 * 매출 테이블(Sales) 엔티티의 레포지토리
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

public interface SaleRepository extends JpaRepository<Sales, Long>{
	public Sales findByStoreStoreId(Long store_Id);
}

