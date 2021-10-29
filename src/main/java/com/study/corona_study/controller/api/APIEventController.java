package com.study.corona_study.controller.api;


import com.study.corona_study.constant.ErrorCode;
import com.study.corona_study.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvent(){
        throw new GeneralException("test");
        //return List.of("event1", "event2");
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

    @ExceptionHandler
    public ModelAndView errorHtml(HttpServletResponse response){
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError()?ErrorCode.BAD_REQUEST:ErrorCode.INTERNAL_ERROR;

        return new ModelAndView("error", Map.of(
                "statusCode", status.value(),
                "errorCode",errorCode,
                "message",errorCode.getMessage(status.getReasonPhrase())
        ),
                status
        );
    }

}
