package com.study.corona_study.dto;


import com.study.corona_study.constant.ErrorCode;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class APIErrorResponse {

    private final boolean success;
    private final int errorCode;
    private final String message;

    public static APIErrorResponse of(boolean success, int errorCode, String message){
        return new APIErrorResponse(success, errorCode, message);
    }

    public static APIErrorResponse of(boolean success, ErrorCode errorCode){
        return new APIErrorResponse(success, errorCode.getCode(), errorCode.getMessage());
    }

    public static APIErrorResponse of(boolean success, ErrorCode errorCode, Exception e){
        return new APIErrorResponse(success, errorCode.getCode(),errorCode.getMessage(e));
    }
    public static APIErrorResponse of(boolean success, ErrorCode errorCode, String message){
        return new APIErrorResponse(success,errorCode.getCode(),message);
    }
}
