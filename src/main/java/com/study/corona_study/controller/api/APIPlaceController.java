package com.study.corona_study.controller.api;

import com.study.corona_study.dto.APIDataResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {
    @GetMapping("/places")
    public APIDataResponse<List<>> getPlace(){
        return List.of("place1", "place2");
    }

    @PostMapping("/places")
    public Boolean createPlace(){
        return true;
    }

    @GetMapping("/places/{placeId}")
    public String getPlaceDetail(@PathVariable int placeId){
        return "place : "+placeId;
    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable int placeId){
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean deletePlace(@PathVariable int placeId){
        return true;
    }
    
}
