package com.scytalys.technikon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExistingUserAdvice {

    @ResponseBody
    @ExceptionHandler(ExistingUserException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> exceptionHandler(ExistingUserException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());

        return errorMap;
    }
}
