package com.study.corona_study.controller;


import com.study.corona_study.exception.GeneralException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//ErrorController 구현하면 error페이지 제어가능 -> 안하면 baseController#error 어쩌고 뜸
public class BaseController {

    //루트 - 메인페이지 띄워줄거 설정함.
    //페이지 설정 안해놓으면 기본적으로 JSP view파일을 찾으려고 함.
    //main 내부의 webapp 안에 view 넣어주면 됨.
    //JSP쓸거면 재스퍼 디펜던시 추가해줘야되고 암튼 더 뭔가 해줘야됨.
    //템플릿엔진(타임리프같은거) 쓰면 webapp폴더 이런거 없이 resouces/template에 넣어서 관리함
    //아니면 그냥 static에 index 넣어주면 웰컴페이지(메인페이지)로 설정된다.
    @GetMapping("/")
    public String root(){
        return "index";
    }

    @GetMapping("/errorTest")
    public String errorTest() throws Exception{
        throw new Exception("test");
    }


}
