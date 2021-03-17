package com.example.apigateway.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sa
 * @date 17.03.2021
 * @time 11:26
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler
{
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public String handleUnauthorizedRequest(HttpServletRequest req, UnauthorizedException ex)
    {
        log.error("Unauthorized Exception occurred on path:{} ", req.getRequestURI(), ex);

        return "Unauthorized Exception";
    }

    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(NotEnoughCreditException.class)
    @ResponseBody
    public String handleCreditRequest(HttpServletRequest req, NotEnoughCreditException ex)
    {
        log.error("No enough credit Exception occurred on path:{} ", req.getRequestURI(), ex);

        return "No enough credit";
    }
}
