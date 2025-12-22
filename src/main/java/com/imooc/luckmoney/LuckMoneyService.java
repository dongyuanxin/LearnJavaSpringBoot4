package com.imooc.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckMoneyService {
    @Autowired
    private LuckMoneyRepository repository;

    @Transactional
    public void createTwo() {
        LuckMoneyDO luckMoneyDO1 = new LuckMoneyDO();
        luckMoneyDO1.setProducer("user1");
        luckMoneyDO1.setMoney(new BigDecimal("19.9"));
        repository.save(luckMoneyDO1);

        LuckMoneyDO luckMoneyDO2 = new LuckMoneyDO();
        luckMoneyDO2.setProducer("user2");
        luckMoneyDO2.setMoney(new BigDecimal("1314"));
        repository.save(luckMoneyDO2);
    }
}
