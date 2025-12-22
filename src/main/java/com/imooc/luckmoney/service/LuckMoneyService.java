package com.imooc.luckmoney.service;

import com.imooc.luckmoney.domain.LuckMoney;
import com.imooc.luckmoney.repository.LuckMoneyRepository;
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
        LuckMoney luckMoney1 = new LuckMoney();
        luckMoney1.setProducer("user1");
        luckMoney1.setMoney(new BigDecimal("19.9"));
        repository.save(luckMoney1);

        LuckMoney luckMoney2 = new LuckMoney();
        luckMoney2.setProducer("user2");
        luckMoney2.setMoney(new BigDecimal("1314"));
        repository.save(luckMoney2);
    }
}
