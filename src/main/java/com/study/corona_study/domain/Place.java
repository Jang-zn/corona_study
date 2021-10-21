package com.study.corona_study.domain;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Place {
    private long id;
    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phone;
    private int capacity;
    private String memo;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
