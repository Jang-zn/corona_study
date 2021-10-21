package com.study.corona_study.error;

import com.study.corona_study.constant.ErrorCode;
import com.study.corona_study.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler {

    @ExceptionHandler
    public ModelAndView general(GeneralException e){
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError()?HttpStatus.BAD_REQUEST:HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView("error", Map.of(
                "statusCode", status.value(),
                "errorCode",errorCode,
                "message",errorCode.getMessage(e.getMessage())
        ),
                status
        );
    }

    @ExceptionHandler
    public ModelAndView global(Exception e){
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status =HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView("error", Map.of(
                "statusCode", status.value(),
                "errorCode",errorCode,
                "message",errorCode.getMessage(e.getMessage())
        ),
                status
        );
    }

    
}
