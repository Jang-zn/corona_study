package com.study.corona_study.controller.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@controller + @ResponseBody
//RequestBody를 그대로 출력함
@RequestMapping("/api")
@RestController
public class APIAuthController {

    @GetMapping("/sign-up")
    public String signUp(){
        return "signUp done";
    }

    @GetMapping("/login")
    public String login(){
        return "login done";
    }


}
