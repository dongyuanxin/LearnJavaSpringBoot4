package com.imooc.luckmoney;

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
    public List<LuckMoneyDO> list() {
        return this.respository.findAll();
    }

    @GetMapping("/find/{id}")
    public LuckMoneyDO findById(@PathVariable("id") Integer id) {
        return this.respository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public LuckMoneyDO add(@RequestParam("producer") String producer,
                           @RequestParam("money") BigDecimal money
                         ) {
        LuckMoneyDO luckMoneyDO = new LuckMoneyDO();
        luckMoneyDO.setProducer(producer);
        luckMoneyDO.setMoney(money);
        return this.respository.save(luckMoneyDO);
    }

    @PutMapping("/update/{id}")
    public LuckMoneyDO update(@PathVariable("id") Integer id,
                              @RequestParam("consumer") String consumer) {
        Optional<LuckMoneyDO> optional = this.respository.findById(id);
        if (optional.isPresent()) {
            LuckMoneyDO ins = optional.get();
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
