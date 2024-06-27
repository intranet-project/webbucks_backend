package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 부서 테이블(Department) 엔티티로, 부서 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;	// 부서ID

    @Column(name = "dept_code", nullable = false)
    private String deptCode;		// 부서 코드

    @Column(name = "dept_name", nullable = false)
    private String deptName;	// 부서명

}
