package com.webbucks.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 직원테이블(Employee) 엔티티로, 직원 테이블에 대한 내용을 담고 있음
 * @author 구은재
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;	// 직원ID

    @Column(name = "emp_name", nullable = false)
    private String empName;	// 이름

    @Column(name = "emp_password", nullable = false)
    private String empPassword;	// 비밀ID

    @Column(name = "emp_email", nullable = false)
    private String empEmail;	// 이메일

    @Column(name = "emp_phone", nullable = false)
    private String empPhone;	// 핸드폰

    @Column(name = "emp_address", nullable = false)
    private String empAddress;	// 주소

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_joindate", nullable = false)
    private Date empJoinDate;		// 입사일

    @Column(name = "emp_position", nullable = false)
    private String empPosition;	// 직책

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_code", referencedColumnName = "dept_id")
    private Department department;	// 부서 코드

    @Column(name = "work_state", nullable = false, length = 1)
    private String workState;	// 재직상태
}
