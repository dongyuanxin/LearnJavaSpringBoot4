package com.imooc.luckmoney.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "字段名不能为空")
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;

    @NotNull(message = "金额不能为空")
    private BigDecimal money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
