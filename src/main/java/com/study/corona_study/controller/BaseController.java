package com.study.corona_study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BaseController {

    //루트 - 메인페이지 띄워줄거 설정함.
    //페이지 설정 안해놓으면 기본적으로 JSP view파일을 찾으려고 함.
    //main 내부의 webapp 안에 view 넣어주면 됨.
    //JSP쓸거면 재스퍼 디펜던시 추가해줘야되고 암튼 더 뭔가 해줘야됨.
    @GetMapping("/")
    public String root(){
        return "index";
    }




}
