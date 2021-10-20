package com.study.corona_study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//requestMapping은 클래스레벨에도 매핑 가능 /admin/주소 식으로 이어감
@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping("/places")
    public String adminPlaces(){
        return "admin/places";
    }

    @GetMapping("/places/{placeId}")
    public String adminPlaceDetail(@PathVariable int placeId){
        return "admin/place-detail";
    }

    @GetMapping("/events")
    public String adminEvents(){
        return "admin/events";
    }

    @GetMapping("/events/{eventId}")
    public String adminEventDetail(@PathVariable int eventId){
        return "admin/event-detail";
    }




}
