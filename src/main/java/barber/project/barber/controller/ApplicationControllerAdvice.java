package barber.project.barber.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import barber.project.barber.exception.RecordNotFundExecption;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(RecordNotFundExecption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RecordNotFundExecption ex){
        return ex.getMessage();
    }
}
