package com.study.corona_study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BaseController {

    //루트 - 메인페이지 띄워줄거 설정
    @GetMapping("/")
    public String root(){
        return "index";
    }


}
