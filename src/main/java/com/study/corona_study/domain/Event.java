package com.study.corona_study.domain;


import com.study.corona_study.constant.EventStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {
    private long id;
    private long placeId;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private int currentNumberOfPeople;
    private int capacity;
    private String memo;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
