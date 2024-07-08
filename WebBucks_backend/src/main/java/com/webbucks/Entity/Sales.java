package com.webbucks.Entity;

import javax.persistence.*;
import lombok.Data;

/**
 * 매출 테이블(Sales) 엔티티로, 주문건에 대한 매출 정보를 담고 있음
 * @author 최유빈
 * @version 1.0
 * 2024-06-27
 * **/

@Entity
@Table(name = "Sales")
@Data
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_id")
    private Long salesId; //매출 ID
    
   @ManyToOne
   @JoinColumn(name = "store_id", nullable = false)
    private Store store; // 매장 ID

    @Column(name = "sale_total_amount", nullable = false)
    private Long saleTotalAmount; // 총매출
}