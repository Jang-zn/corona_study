package com.study.corona_study.controller.api;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvent(){
        return List.of("event1", "event2");
    }

    @PostMapping("/events")
    public Boolean createEvent(){
        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEventDetail(@PathVariable int eventId){
        return "event : "+eventId;
    }

    @PutMapping("/events/{eventId}")
    public Boolean modifyEvent(@PathVariable int eventId){
        return true;
    }

    @DeleteMapping("/events/{eventId}")
    public Boolean deleteEvent(@PathVariable int eventId){
        return true;
    }


}
