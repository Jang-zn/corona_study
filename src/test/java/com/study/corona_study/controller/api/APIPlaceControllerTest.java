package com.study.corona_study.controller.api;

import com.study.corona_study.constant.ErrorCode;
import com.study.corona_study.constant.PlaceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(APIPlaceController.class)
class APIPlaceControllerTest {

    private final MockMvc mvc;

    public APIPlaceControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("[API][GET] 장소 리스트 조회")
    @Test
    void givenNothing_whenRequestingPlaces_thenReturnListOfPlacesInStandardResponse() throws Exception{
        //Given


        //When&Then
        mvc.perform(get("/api/places"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data[0].placeName").value("Bad민턴"))
                .andExpect(jsonPath("$.data[0].address").value("서울 어디"))
                .andExpect(jsonPath("$.data[0].phone").value("010-1111-2222"))
                .andExpect(jsonPath("$.data[0].capacity").value(30))
                .andExpect(jsonPath("$.data[0].memo").value("신규"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));

    }

    @DisplayName("[API][GET] 단일 장소 조회 - 장소 있는경우")
    @Test
    void givenPlaceId_whenRequestingPlace_thenReturnPlaceInStandardResponse() throws Exception{
        //Given
        int placeId = 1;
        //When&Then
        //JsonPath 사용할 경우 Json 문법으로 검사한다.
        mvc.perform(get("/api/places/"+placeId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isMap())
                .andExpect(jsonPath("$.data.placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data.placeName").value("Bad민턴"))
                .andExpect(jsonPath("$.data.address").value("서울 어디"))
                .andExpect(jsonPath("$.data.phone").value("010-1111-2222"))
                .andExpect(jsonPath("$.data.capacity").value(30))
                .andExpect(jsonPath("$.data.memo").value("신규"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));

    }

    @DisplayName("[API][GET] 단일 장소 조회 - 장소 없는경우")
    @Test
    void givenWrongPlaceId_whenRequestingPlace_thenReturnEmptyInStandardResponse() throws Exception{
        //Given
        int placeId = 2;
        //When&Then
        mvc.perform(get("/api/places/"+placeId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isEmpty())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
    }

}