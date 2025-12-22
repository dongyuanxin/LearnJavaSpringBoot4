package com.imooc.luckmoney.repository;

import com.imooc.luckmoney.domain.LuckMoneyDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckMoneyRepository extends JpaRepository<LuckMoneyDO, Integer> {

}
