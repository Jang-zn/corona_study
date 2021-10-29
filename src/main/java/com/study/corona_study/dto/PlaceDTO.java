package com.study.corona_study.dto;

import com.study.corona_study.constant.PlaceType;

public record PlaceDTO(
        PlaceType placeType,
        String placeName,
        String address,
        String phone,
        int capacity,
        String memo
) {
    public static PlaceDTO of(
            PlaceType placeType,
            String placeName,
            String address,
            String phone,
            int capacity,
            String memo)
    {
        return new PlaceDTO(placeType, placeName, address, phone, capacity, memo);
    }
}
