package com.study.corona_study.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class BaseControllerTest {

    private final MockMvc mvc;

    public BaseControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }


    @DisplayName("[view][GET]기본요청")
    @Test
    //테스트 메소드명 명명 규칙
    //1. 메소드명에 실제 사용되는 메소드 명을 넣는건 좋은방법이 아님
    //2. Should 방식 : page명Should기대동작
    //3. given_when_then : givenNothing_whenRequestingRootPage_thenReturnIndexPage
    //4. @DisplayName
    void indexSholudShowIndexPage() throws Exception{
        //Given

        //When&Then
        mvc.perform(get("/"))
              .andExpect(status().isOk())
              .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
              .andExpect(content().string(containsString("hi~")))
              .andExpect(view().name("index"))
              .andDo(print());
    }
}