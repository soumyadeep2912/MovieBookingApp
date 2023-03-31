package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.exception.MovieDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;
   private static Movie movie;
//   @BeforeEach
//  public void beforeEach(){
//   movie=new Movie();
// movie.setMovieName("Pathan");
//  movie.setMovieDesc("Good");
//  movie.setRating(10);
//  movie.setDuration(280.0);
//   movie.setCoverPhtUrl("www.coverphtUrl.com");
//  movie.setTrailerUrl("www.trailerUrl.com");
//
//    }

//    @Test
//    public void testCreateMovie(){
//        movie=new Movie();
//        movie.setMovieId("1");
//        movie.setMovieName("Pathan");
//        movie.setMovieDesc("Good");
//        movie.setRating(10);
//        movie.setDuration(280.0);
//        movie.setCoverPhtUrl("www.coverphtUrl.com");
//        movie.setTrailerUrl("www.trailerUrl.com");
//      Movie actualMovieObject=movieService.createMovie(movie);
//       Assertions.assertNotNull(actualMovieObject);
//      Assertions.assertEquals(0,actualMovieObject.getMovieId());
//
//        System.out.println(movieService);
//    }
    @Test
    public void testGetMovieDetails() throws MovieDetailsNotFoundException {
        Movie savedMovie=movieService.getMovieBasedOnId("640c48ffd4656b7352640470");
        Assertions.assertNotNull(savedMovie);

    }
}
