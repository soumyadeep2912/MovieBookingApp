package com.BookMyShow.Its.a.movie.booking.application.controller;

import com.BookMyShow.Its.a.movie.booking.application.dto.TheatreDto;
import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import com.BookMyShow.Its.a.movie.booking.application.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public Theatre convertTheatreDtoEntity(TheatreDto theatreDto){
        Theatre newTheatre=new Theatre();
        newTheatre.setCity(theatreDto.getCity());
        newTheatre.setAddress(theatreDto.getAddress());
        newTheatre.setName(theatreDto.getName());
        newTheatre.setScreenCount(newTheatre.getScreenCount());
        newTheatre.setMovieScreening(newTheatre.getMovieScreening());
        return newTheatre;
    }
    public TheatreDto convertEntityToTheatreDto(Theatre theatre){
        TheatreDto newTheatre=new TheatreDto();
        newTheatre.setName(theatre.getName());
        newTheatre.setAddress(theatre.getAddress());
        newTheatre.setCity(theatre.getCity());
        newTheatre.setScreenCount(theatre.getScreenCount());
        newTheatre.setMovieScreening(theatre.getMovieScreening());
        newTheatre.set_id(theatre.get_id());
        return newTheatre;
    }

}
