package com.imooc.luckmoney.service;

import com.imooc.luckmoney.domain.ResultStatus;
import com.imooc.luckmoney.exception.HttpApiBaseException;
import com.imooc.luckmoney.repository.GirlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GirlService {
    @Autowired
    private GirlRepository repository;

    public void getAge(Integer age) {
        if (age < 22) {
            throw new HttpApiBaseException(ResultStatus.USER_UNVALID);
        }
    }
}
