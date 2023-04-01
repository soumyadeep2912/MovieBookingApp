package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.exception.MovieDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieServiceUnitTest {
    @Mock
    MovieRepository movieRepository;

    @InjectMocks
   private MovieService movieService;
    private Movie movie;
    private Movie savedMovie;

    @BeforeEach
    public void beforeEach(){
                movie=new Movie();
                movie.setMovieName("Pathan");
                movie.setMovieDesc("Good");
                movie.setRating(10);
                movie.setDuration(280.0);
                movie.setCoverPhtUrl("www.coverphtUrl.com");
                movie.setTrailerUrl("www.trailerUrl.com");

                savedMovie=new Movie();
                savedMovie.setMovieId("0");
                savedMovie.setMovieName("Pathan");
                savedMovie.setMovieDesc("Good");
                savedMovie.setRating(10);
               savedMovie.setDuration(280.0);
               savedMovie.setCoverPhtUrl("www.coverphtUrl.com");
               savedMovie.setTrailerUrl("www.trailerUrl.com");




    }
    @Test
    public void testMovieDetails(){
        Mockito.when(movieRepository.save(movie)).thenReturn(savedMovie);
        Movie savedMovie = movieService.createMovie(movie);
        Assertions.assertNotNull(savedMovie);
        Assertions.assertEquals("0",savedMovie.getMovieId());

       // System.out.println(movieService);
    }
    @Test
    public void testGetMovieDetails() throws MovieDetailsNotFoundException {
        Mockito.when(movieRepository.findMovieById("0")).thenReturn(savedMovie);
        Movie savedMovie=movieService.getMovieBasedOnId("0");
        Assertions.assertNotNull(savedMovie);
    }

}
