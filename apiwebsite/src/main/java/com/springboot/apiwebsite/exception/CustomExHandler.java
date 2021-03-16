package com.springboot.apiwebsite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExHandler {
  @ExceptionHandler(AccountEx.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseError handlerEx(AccountEx ex ,WebRequest req) {
	  return new ResponseError(HttpStatus.BAD_REQUEST, ex.getMessage());
  }
}
