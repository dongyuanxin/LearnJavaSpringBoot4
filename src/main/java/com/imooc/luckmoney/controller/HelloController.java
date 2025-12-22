package com.imooc.luckmoney.controller;

import com.imooc.luckmoney.propterties.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
// @Controller 默人是读取，需要配合 @ResponseBody 才能等于 @RestController。一般不这么用。
// 除非是一个controller里，部分方法是直接返回值，其他方法返回页面。那么就需要给返回值的方法单独使用 @ResponseBody 注解，同时返回页面的方法返回模版名
@RestController
@RequestMapping("/v1")
public class HelloController {

    @Value("${limit.minMoney}")
    private BigDecimal minMoney;

    @Autowired
    private LimitConfig limitConfig;

//    @RequestMapping // 旧的注解写法
    @GetMapping({"/hi", "/hello"})
    public String say() {
        return "minMoney: " + this.minMoney + "\n" + "description: " + this.limitConfig.getDescription();
    }

    @PostMapping("/hello")
    public String postSay() {
        return "minMoney: " + this.minMoney + "\n" + "description: " + this.limitConfig.getDescription();
    }

    // @RequestParam 内部处理了post、get等方式的兼容。如果是post，通过form-urlencoded也可以通过这个注解拿到。
    @GetMapping("/user/{id}")
    public String getUserId(@PathVariable("id") Integer id, @RequestParam(value = "name", required = false, defaultValue = "") String name){
        StringBuilder str = new StringBuilder();
        if (name != null && name.length() > 0) {
            str.append("name: " + name);
        }
        if (id != null) {
            str.append("; id: " + id);
        }
        return str.toString();
    }
}
