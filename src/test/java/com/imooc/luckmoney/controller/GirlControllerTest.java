package com.imooc.luckmoney.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addTest() {
    }

    @Test
    void getAgeTest() throws  Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girl/getAge/18"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}