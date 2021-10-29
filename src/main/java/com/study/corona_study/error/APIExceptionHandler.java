package com.study.corona_study.error;

import com.study.corona_study.constant.ErrorCode;
import com.study.corona_study.dto.APIErrorResponse;
import com.study.corona_study.exception.GeneralException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
//Spring boot 내부적으로 발생하는 예외는 모두 찾아서 처리하기 어려움
//그럴땐 ResponseEntityExceptionHandler 상속받아서 사용하자
//얘가 알아서 처리해줌
//근데 내부 코드 보면 body에 null처리해놓고 있어서 구현해줄 필요가 있음 ->handleExceptionInternal Override
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> general(GeneralException e, WebRequest request){
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError()?HttpStatus.BAD_REQUEST:HttpStatus.INTERNAL_SERVER_ERROR;
//        return ResponseEntity
//                .status(status)
//                .body(APIErrorResoponse.of(false, errorCode,errorCode.getMessage(e))
//                );
        return super.handleExceptionInternal(e,
                APIErrorResponse.of(false,errorCode.getCode(),errorCode.getMessage(e)),
                HttpHeaders.EMPTY, status, request);
    }



    @ExceptionHandler
    public ResponseEntity<Object> global(Exception e, WebRequest request){
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return super.handleExceptionInternal(e,
                APIErrorResponse.of(
                        false
                        ,errorCode.getCode(),errorCode.getMessage(e))
                        ,HttpHeaders.EMPTY
                        , status, request);
    }

    //Body부분만 재구현해준다.
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorCode errorCode = status.is4xxClientError()?
                ErrorCode.SPRING_BAD_REQUEST:
                ErrorCode.SPRING_INTERNAL_ERROR;

        return super.handleExceptionInternal(ex,
                APIErrorResponse.of(false,errorCode.getCode(),errorCode.getMessage(ex)),
                headers, status, request);
    }
    
}
