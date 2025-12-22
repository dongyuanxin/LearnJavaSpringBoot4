package com.imooc.luckmoney.repository;

import com.imooc.luckmoney.domain.LuckMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckMoneyRepository extends JpaRepository<LuckMoney, Integer> {

}
