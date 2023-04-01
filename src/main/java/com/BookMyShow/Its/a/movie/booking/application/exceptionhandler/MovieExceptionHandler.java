package com.BookMyShow.Its.a.movie.booking.application.exceptionhandler;

import com.BookMyShow.Its.a.movie.booking.application.exception.InvalidMovieNameProvidedException;
import com.BookMyShow.Its.a.movie.booking.application.exception.MovieDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler(MovieDetailsNotFoundException.class)
    public ResponseEntity handleMovieDetailsNotFoundException(){
        return new ResponseEntity("Movie id is not correct", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidMovieNameProvidedException.class)
    public ResponseEntity handleBadMovieRequestException(){
        return new ResponseEntity("Request Passed Body is having problems",HttpStatus.BAD_REQUEST);
    }
}
