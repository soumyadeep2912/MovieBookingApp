package com.BookMyShow.Its.a.movie.booking.application.exceptionhandler;

import com.BookMyShow.Its.a.movie.booking.application.exception.TheatreDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TheatreExceptionHandler {
    @ExceptionHandler(TheatreDetailsNotFoundException.class)
    public ResponseEntity handleTheatreDetailsNotFoundException(){
        return new ResponseEntity("Theatre Details Not Found Exception", HttpStatus.BAD_REQUEST);
    }

}
