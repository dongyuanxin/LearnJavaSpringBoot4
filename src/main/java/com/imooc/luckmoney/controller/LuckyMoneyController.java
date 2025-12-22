package com.imooc.luckmoney.controller;

import com.imooc.luckmoney.domain.LuckMoney;
import com.imooc.luckmoney.repository.LuckMoneyRepository;
import com.imooc.luckmoney.service.LuckMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/v2")
public class LuckyMoneyController {

    @Autowired
    private LuckMoneyRepository respository;

    @Autowired
    private LuckMoneyService service;

    @GetMapping("/list")
    public List<LuckMoney> list() {
        return this.respository.findAll();
    }

    @GetMapping("/find/{id}")
    public LuckMoney findById(@PathVariable("id") Integer id) {
        return this.respository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public LuckMoney add(@RequestParam("producer") String producer,
                         @RequestParam("money") BigDecimal money
                         ) {
        LuckMoney luckMoney = new LuckMoney();
        luckMoney.setProducer(producer);
        luckMoney.setMoney(money);
        return this.respository.save(luckMoney);
    }

    @PutMapping("/update/{id}")
    public LuckMoney update(@PathVariable("id") Integer id,
                            @RequestParam("consumer") String consumer) {
        Optional<LuckMoney> optional = this.respository.findById(id);
        if (optional.isPresent()) {
            LuckMoney ins = optional.get();
            ins.setConsumer(consumer);
            return this.respository.save(ins);
        }

        return null;
    }

    @PostMapping("/createTwo")
    public boolean createTwo() {
        try {
            this.service.createTwo();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
