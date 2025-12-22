package com.imooc.luckmoney.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
//import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

//@Slf4j
// 注意下 entity 里，不能使用 @Data 和 @Entity。前者会生成hashCode 和 eqauls，干扰 JPA
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "luck_money")
public class LuckMoney {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal money;

    private String producer;

    private String consumer;
}
