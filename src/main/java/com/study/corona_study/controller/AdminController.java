package com.study.corona_study.controller;


import com.study.corona_study.constant.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//requestMapping은 클래스레벨에도 매핑 가능 /admin/주소 식으로 이어감
@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping("/places")
    // requestParam 명시할때 / 안할때 차이는 명시할 경우 required=true가 default라서 필수값으로 지정 가능
    // 명시하지 않아도 사용은 가능하다. -> Collection Data가 아닌 단일객체면 알아서 인식함
    public ModelAndView adminPlaces(
            PlaceType placeType,
            String placeName,
            String address
    ){
        // TODO:인증기능
        Map<String, Object> map = new HashMap();
        map.put("placeType",placeType);
        map.put("placeName",placeName);
        map.put("address",address);
        return new ModelAndView("admin/places", map);
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
