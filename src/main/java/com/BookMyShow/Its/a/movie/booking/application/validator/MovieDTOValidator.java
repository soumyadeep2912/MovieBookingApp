package com.BookMyShow.Its.a.movie.booking.application.validator;

import com.BookMyShow.Its.a.movie.booking.application.dto.MovieDto;
import com.BookMyShow.Its.a.movie.booking.application.exception.InvalidMovieNameProvidedException;

public class MovieDTOValidator {

    public static boolean isValid(MovieDto movieDto) throws InvalidMovieNameProvidedException {
        if(movieDto.getMovieName()==null || movieDto.getMovieName()==""){
            throw new InvalidMovieNameProvidedException("Movie Name is empty or null");
        }
        if (movieDto.getMovieDesc()==null||movieDto.getMovieDesc()==""){
            throw new InvalidMovieNameProvidedException("Movie Description is empty or null");
        }
        if(movieDto.getDuration()==0||movieDto.getDuration()>50 || movieDto.getDuration()<500){
            throw new InvalidMovieNameProvidedException("Movie duration is empty or between 50 to 500");
        }
        if(movieDto.getRating()==0){
            throw new InvalidMovieNameProvidedException("Movie Rating is empty or null");
        }
        if(movieDto.getCoverPhtUrl()==null || movieDto.getCoverPhtUrl()==""){
            throw new InvalidMovieNameProvidedException("Movie CoverPhtUrl is empty or null");
        }
        if(movieDto.getTrailerUrl()==null ||movieDto.getTrailerUrl()==""){
            throw new InvalidMovieNameProvidedException("Movie TrailerUrl is empty or null");
        }
        return true;
    }

}
