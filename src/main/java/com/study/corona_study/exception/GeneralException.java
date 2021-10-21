package com.study.corona_study.exception;


import com.study.corona_study.constant.ErrorCode;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException{
    private final ErrorCode errorCode;


    //생성자 매개변수들은 RuntimeException 내부 생성자를 그대로 구현한것
    public GeneralException(){
        super();
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(String message){
        super(message);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message, Throwable cause){
        super(message, cause);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(Throwable cause){
        super(cause);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public GeneralException(ErrorCode errorCode, Throwable cause){
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }
    public GeneralException(ErrorCode errorCode,Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(errorCode.getMessage(), cause,enableSuppression,writableStackTrace);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }


}
