package com.study.corona_study.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class APIDataResoponse extends APIErrorResoponse{

    private final Object data;

    private APIDataResoponse(boolean success, int errorCode, String message, Object data){
        super(success,errorCode,message);
        this.data = data;
    }

    public static APIDataResoponse of(boolean success, int errorCode, String message, Object data){
        return new APIDataResoponse(success,errorCode,message,data);
    }
}
