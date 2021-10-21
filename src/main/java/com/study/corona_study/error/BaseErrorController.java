package com.study.corona_study.error;

import com.study.corona_study.constant.ErrorCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class BaseErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView errorTest(HttpServletResponse response){
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

}