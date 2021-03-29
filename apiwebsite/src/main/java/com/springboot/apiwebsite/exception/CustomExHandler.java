package com.springboot.apiwebsite.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class CustomExHandler {
  @ExceptionHandler(BadRequestEx.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseError handlerEx(BadRequestEx ex ,WebRequest req) {
	  return new ResponseError(HttpStatus.BAD_REQUEST, ex.getMessage());
  }
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult().getAllErrors().forEach((error) -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
      });
      return errors;
  }	
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ErrorFoundEx.class)
  public ResponseError handlerFoundEx(ErrorFoundEx ex , WebRequest req) {
	  return new ResponseError(HttpStatus.NOT_FOUND, ex.getMessage());
  }
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseError handlerException(Exception ex, WebRequest req) {
      // Log err

      return new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
  }
}
