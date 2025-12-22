package com.imooc.luckmoney.controller;

import com.imooc.luckmoney.domain.Girl;
import com.imooc.luckmoney.domain.HttpApiResult;
import com.imooc.luckmoney.domain.ResultStatus;
import com.imooc.luckmoney.repository.GirlRepository;
import com.imooc.luckmoney.service.GirlService;
import com.imooc.luckmoney.utils.ResultFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/girl")
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @PostMapping("/add")
    public HttpApiResult<Girl> add(@Validated Girl girl, BindingResult bindRes) {
        log.info("bindRes.hasErrors() is ", bindRes);
        if (bindRes.hasErrors()) {
            log.info("bindRes.getFieldError().getDefaultMessage() is ", bindRes.getFieldError().getDefaultMessage());
            String defaultMsg = bindRes.getFieldError().getDefaultMessage();
            StringBuilder str = new StringBuilder("参数错误");
            if (defaultMsg != null) {
                str.append("-");
                str.append(str);
            }
            return ResultFormat.error(ResultStatus.PARAMS_ERROR);
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultFormat.success(girlRepository.save(girl));
    }

    @GetMapping("/getAge/{age}")
    public void getAge(@PathVariable("age") Integer age) {
        girlService.getAge(age);
    }
}
