package com.BookMyShow.Its.a.movie.booking.application.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.BookMyShow.Its.a.movie.booking.application.dto.MovieDto;
import com.BookMyShow.Its.a.movie.booking.application.exception.MovieDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    ElasticsearchClient elasticsearchClient;


  @PostMapping("/created")
    public ResponseEntity createMovieDetails(@RequestBody MovieDto movieDto){
     Movie movieEntity=convertMovieDtoToEntity(movieDto);
     Movie savedEntity=movieService.createMovie(movieEntity);
     MovieDto responseBody=convertEntityToMovieDto(savedEntity);
     return new ResponseEntity(responseBody,HttpStatus.CREATED);
    }

   @GetMapping("/getAll")
   public ResponseEntity getAllMovies(){
      List<Movie>allMovies=movieService.getMovies();
      List<MovieDto>allMovieDto=new ArrayList<>();
      for(Movie movie:allMovies){
          MovieDto movieDto=convertEntityToMovieDto(movie);
          allMovieDto.add(movieDto);
      }
      return new ResponseEntity(allMovieDto,HttpStatus.OK);
   }
    @DeleteMapping("/{movie_id}")
    public String deleteMovieDetails(@PathVariable(name="movie_id")String movieId){
        movieService.deleteMovieDetails(movieId);
        return "deleted";
    }
   @GetMapping("/getMovie")
   public ResponseEntity getMoviesBasedOnMovieName(@RequestParam(name="movie_name")String movieName){
      Movie movie=movieService.getMovieByMovieName(movieName);
      MovieDto responseBody=convertEntityToMovieDto(movie);
      return new ResponseEntity(responseBody,HttpStatus.OK);
   }
   @GetMapping("/getDuration/{duration}")
   public ResponseEntity getMoviesBasedOnDuration(@PathVariable(name="duration")double duration){
      Movie movie=movieService.getMovieByDuration(duration);
      MovieDto responsebody=convertEntityToMovieDto(movie);
      return new ResponseEntity(responsebody,HttpStatus.OK);
   }

   @GetMapping("/{movie_id}")
   public ResponseEntity getMoviesBasedOnId(@PathVariable(name="movie_id")String movieId)throws
           MovieDetailsNotFoundException {
      Movie movie=movieService.getMovieBasedOnId(movieId);
      MovieDto movieDto=convertEntityToMovieDto(movie);
    return new ResponseEntity(movieDto,HttpStatus.OK);
   }


   @PutMapping("/update/{movie_id}")
   public ResponseEntity upDateMovieDetails(@PathVariable(name="movie_id") String movieId,
                                            @RequestBody MovieDto movieDto)
           throws MovieDetailsNotFoundException {

    Movie movieEntity=convertMovieDtoToEntity(movieDto);
    Movie savedEntity=movieService.updateMovieDetails(movieId,movieEntity);
    MovieDto responseBody=convertEntityToMovieDto(savedEntity);
    return new ResponseEntity(responseBody,HttpStatus.CREATED);

   }

    private Movie convertMovieDtoToEntity(MovieDto movieDto){
      Movie movie=new Movie();
      movie.setMovieId(movieDto.getMovieId());
      movie.setMovieDesc(movieDto.getMovieDesc());
      movie.setDuration(movieDto.getDuration());
      movie.setRating(movieDto.getRating());
      movie.setTrailerUrl(movieDto.getTrailerUrl());
      movie.setCoverPhtUrl(movieDto.getCoverPhtUrl());
      movie.setMovieName(movieDto.getMovieName());
      return movie;
    }
    private MovieDto convertEntityToMovieDto(Movie movie){
        MovieDto movieDto=new MovieDto();
        movieDto.setMovieId(movie.getMovieId());
        movieDto.setMovieDesc(movie.getMovieDesc());
        movieDto.setDuration(movie.getDuration());
        movieDto.setRating(movie.getRating());
        movieDto.setTrailerUrl(movie.getTrailerUrl());
        movieDto.setCoverPhtUrl(movie.getCoverPhtUrl());
        movieDto.setMovieName(movie.getMovieName());
        return movieDto;
    }
}
