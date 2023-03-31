package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    private Movie movie;
    @Test
    public void beforeEach(){
   movie=new Movie();
   movie.setMovieName("Pathan");
   movie.setMovieDesc("Good");
   movie.setRating(10);
   movie.setDuration(280.0);
   movie.setCoverPhtUrl("www.coverphtUrl.com");
   movie.setTrailerUrl("www.trailerUrl.com");

    }

    @Test
    public void testCreateMovie(){
        Movie actualMovieObject=movieService.createMovie(movie);
        Assertions.assertNotNull(actualMovieObject);
       // Assertions.assertEquals(0,actualMovieObject.getMovieId());
        Assertions.assertEquals(1,actualMovieObject.getMovieId());
        System.out.println(movieService);
    }
}
