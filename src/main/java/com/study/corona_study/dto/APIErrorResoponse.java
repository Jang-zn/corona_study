package com.study.corona_study.dto;


import com.study.corona_study.constant.ErrorCode;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
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
