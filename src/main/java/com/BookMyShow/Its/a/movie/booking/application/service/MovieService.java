package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.ItsAMovieBookingApplication;
import com.BookMyShow.Its.a.movie.booking.application.exception.MovieDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {

        return movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return movieRepository.findMovie();
    }
    public Movie getMovieByMovieName(String movieName){
        return movieRepository.findMovieByName(movieName);
    }

    public Movie getMovieBasedOnId(String movieId) throws MovieDetailsNotFoundException {
        Movie movie = movieRepository.findMovieById(movieId);
        if (movie == null) {
            throw new MovieDetailsNotFoundException("movie is not found for this provided id" + movieId);
        }

        return movie;

    }

    public Movie updateMovieDetails(String movieId, Movie movie) throws MovieDetailsNotFoundException {
        Movie savedMovie = movieRepository.findMovieById(movieId);
        if (savedMovie == null) {
            throw new MovieDetailsNotFoundException("MovieId is not found for this Id");
        }
        if(savedMovie.getMovieDesc()!=null){
            savedMovie.setMovieDesc(movie.getMovieDesc());
        }
        if(savedMovie.getMovieName()!=null){
            savedMovie.setMovieName(movie.getMovieName());
        }
        return movieRepository.save(savedMovie);
    }
    public Movie getMovieByDuration(double duration){
        Movie savedMovie=movieRepository.findMovieByDuration(duration);
        return savedMovie;
    }
    public boolean deleteMovieDetails(String movieId){
        movieRepository.deleteById(movieId);
        return true;
    }
    public Movie getMovieByRating(int rating){
        Movie savedMovie=movieRepository.findMovieByRating(rating);
        return savedMovie;
    }


}



