package com.study.corona_study.dto;


import com.study.corona_study.constant.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class APIErrorResoponse {

    private final boolean success;
    private final int errorCode;
    private final String message;

    public static APIErrorResoponse of(boolean success, int errorCode, String message){
        return new APIErrorResoponse(success, errorCode, message);
    }

    public static APIErrorResoponse of(boolean success, ErrorCode errorCode){
        return new APIErrorResoponse(success, errorCode.getCode(), errorCode.getMessage());
    }

    public static APIErrorResoponse of(boolean success, ErrorCode errorCode, Exception e){
        return new APIErrorResoponse(success, errorCode.getCode(),errorCode.getMessage(e));
    }
    public static APIErrorResoponse of(boolean success, ErrorCode errorCode, String message){
        return new APIErrorResoponse(success,errorCode.getCode(),message);
    }
}
