package com.study.corona_study.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

     OK(0,ErrorCategory.NORMAL, "Ok"),
     BAD_REQUEST(10000, ErrorCategory.CLIENT_SIDE, "Bad request"),
     SPRING_BAD_REQUEST(10001, ErrorCategory.CLIENT_SIDE, "Spring-detected Bad request"),
     INTERNAL_ERROR(20000, ErrorCategory.SERVER_SIDE, "Internal error"),
     SPRING_INTERNAL_ERROR(20001, ErrorCategory.SERVER_SIDE, "Spring-detected Internal error");


    private final int code;
    private final ErrorCategory errorCategory;
    private final String message;

    public String getMessage(Exception e){
        return getMessage(e.getMessage());
    }

    public String getMessage(String message){
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(getMessage());
    }

    public boolean isClientSideError(){
        return this.getErrorCategory()==ErrorCategory.CLIENT_SIDE;
    }
    public boolean isServerSideError(){
        return this.getErrorCategory()==ErrorCategory.SERVER_SIDE;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name(), this.getCode());
    }


    public enum ErrorCategory{
        NORMAL, CLIENT_SIDE, SERVER_SIDE
    }
}
