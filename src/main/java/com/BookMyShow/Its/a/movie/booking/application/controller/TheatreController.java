package com.BookMyShow.Its.a.movie.booking.application.controller;

import com.BookMyShow.Its.a.movie.booking.application.dto.MovieDto;
import com.BookMyShow.Its.a.movie.booking.application.dto.TheatreDto;
import com.BookMyShow.Its.a.movie.booking.application.exception.TheatreDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import com.BookMyShow.Its.a.movie.booking.application.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping("/create")
    public ResponseEntity addTheatre(@RequestBody TheatreDto theatreDto){
        Theatre theatreEntity= convertTheatreDtoEntity(theatreDto);
        Theatre savedEntity=theatreService.addTheatre(theatreEntity);
        TheatreDto responseBody=convertEntityToTheatreDto(savedEntity);
        return new ResponseEntity(responseBody, HttpStatus.CREATED);
    }
    @GetMapping("/getTheatre/{theatreId}")
    public ResponseEntity getTheatreBasedOnId(@PathVariable(name="theatreId")String theatreId)
            throws TheatreDetailsNotFoundException {
        Theatre theatre=theatreService.getTheatre(theatreId);
        TheatreDto theatreDto=convertEntityToTheatreDto(theatre);
        return new ResponseEntity(theatreDto,HttpStatus.OK);

    }
    @PostMapping("/{theatreName}/movies")
    public ResponseEntity addMoviesToTheatre(@PathVariable(name="theatreName") String theatreName,
                                             @RequestBody Movie movie){

     theatreService.addMoviesToTheatre(theatreName,movie);


        return  ResponseEntity.ok().build();

    }
    @GetMapping("/{theatreName}/movies")
    public ResponseEntity<List<Movie>> getMoviesByTheatre(@PathVariable(name="theatreName")String theatreName){
    List<Movie>movies=theatreService.getMoviesByTheatreName(theatreName);
        if (movies == null || movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies);

    }
    @GetMapping("/all")
    public ResponseEntity allTheatres(){
        List<Theatre> allTheatres=theatreService.getTheatres();
        List<TheatreDto> theatres=new ArrayList<TheatreDto>();
        for(Theatre theatre: allTheatres){
            TheatreDto the=convertEntityToTheatreDto(theatre);
            theatres.add(the);

        }
        return new ResponseEntity(theatres, HttpStatus.OK);
    }
    @GetMapping("/{theatre_name}")
    public ResponseEntity theatreDetails(@PathVariable(name="theatre_name")String theatreName){

        Theatre response=theatreService.getTheatreName(theatreName);

        TheatreDto theatre=convertEntityToTheatreDto(response);
        return new ResponseEntity(theatre,HttpStatus.OK);
    }
    public Theatre convertTheatreDtoEntity(TheatreDto theatreDto){
        Theatre newTheatre=new Theatre();
        newTheatre.setCity(theatreDto.getCity());
        newTheatre.setAddress(theatreDto.getAddress());
        newTheatre.setName(theatreDto.getName());
        newTheatre.setScreenCount(newTheatre.getScreenCount());
        newTheatre.setMovieScreening(newTheatre.getMovieScreening());
        newTheatre.setMovies(theatreDto.getMovies());

        return newTheatre;
    }
    public TheatreDto convertEntityToTheatreDto(Theatre theatre){
        TheatreDto newTheatre=new TheatreDto();
        newTheatre.setName(theatre.getName());
        newTheatre.setAddress(theatre.getAddress());
        newTheatre.setCity(theatre.getCity());
        newTheatre.setScreenCount(theatre.getScreenCount());
        newTheatre.setMovieScreening(theatre.getMovieScreening());
        newTheatre.setTheatreId(theatre.getTheatreId());
        //newTheatre.setMovies(theatre.getMovies());
        newTheatre.setMovies(theatre.getMovies());
        return newTheatre;
    }

}
