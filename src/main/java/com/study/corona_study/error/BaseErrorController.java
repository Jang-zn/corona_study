package com.study.corona_study.error;

import com.study.corona_study.constant.ErrorCode;
import com.study.corona_study.dto.APIErrorResoponse;
import com.study.corona_study.exception.GeneralException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class BaseErrorController implements ErrorController {

    //View로 보내는방식 / Json으로 보내는 방식 분리하기 위해 RequestMapping에 속성 지정
    @RequestMapping(path="/error", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletResponse response){
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError()?ErrorCode.BAD_REQUEST:ErrorCode.INTERNAL_ERROR;

        return new ModelAndView("error", Map.of(
                "statusCode", status.value(),
                "errorCode",errorCode,
                "message",errorCode.getMessage(status.getReasonPhrase())
                ),
                status
                );
    }

    @RequestMapping("/error")
    public ResponseEntity<APIErrorResoponse> general(HttpServletResponse response) {
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;
        return ResponseEntity
                .status(status)
                .body(APIErrorResoponse.of(false, errorCode)
                );
    }

}
