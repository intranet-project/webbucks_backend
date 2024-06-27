package com.webbucks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webbucks.Entity.Department;

/**
 * 부서 테이블(Department) 엔티티의 레포지토리
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
