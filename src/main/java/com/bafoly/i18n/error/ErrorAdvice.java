package com.bafoly.i18n.error;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

  @Autowired
  MessageSource messageSource;
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ApiError handleMethodArgNotValid(MethodArgumentNotValidException exception, HttpServletRequest request, Locale locale){
    String message = messageSource.getMessage("com.bafoly.validation", null, locale);
    ApiError error = new ApiError(400, message, request.getServletPath());
    BindingResult bindingResult = exception.getBindingResult();
    Map<String, String> validationErrors = new HashMap<>();
    for(FieldError fieldError: bindingResult.getFieldErrors()){
      validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    error.setValidationErrors(validationErrors);
    return error;
  }

}