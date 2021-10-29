package com.study.corona_study.controller.api;

import com.study.corona_study.constant.PlaceType;
import com.study.corona_study.dto.APIDataResponse;
import com.study.corona_study.dto.PlaceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {
    @GetMapping("/places")
    public APIDataResponse<List<PlaceDTO>> getPlace(){
        return APIDataResponse.of(List.of(PlaceDTO.of(
                PlaceType.COMMON,
                "Bad민턴",
                "서울 어디",
                "010-1111-2222",
                30,
                "신규"
        )));
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
