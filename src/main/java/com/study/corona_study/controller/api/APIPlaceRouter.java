package com.study.corona_study.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class APIPlaceRouter {

    @Bean
    public RouterFunction<ServerResponse> placeRouter(APIPlaceHandler handler){
        //nested routing으로 공통 path 지정
        //핸들러 구현 후 핸들러를 콜백함수로 입력
        return route().nest(path("/api/places"),
                builder->builder
                     .GET("", handler::getPlaces)
                     .POST("", handler::createPlace)
                     .GET("/{placeId}", handler::getPlacesDetail)
                     .PUT("/{placeId}", handler::updatePlaceDetail)
                     .DELETE("/{placeId}",handler::deletePlace )
                )
                .build();
    }


}
