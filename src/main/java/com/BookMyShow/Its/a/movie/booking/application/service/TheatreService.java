package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.exception.TheatreDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import com.BookMyShow.Its.a.movie.booking.application.repository.MovieRepository;
import com.BookMyShow.Its.a.movie.booking.application.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieRepository movieRepository;


    public Theatre addTheatre(Theatre theatre){
        return theatreRepository.save(theatre);
    }
    public Theatre getTheatre(String theatreId) throws TheatreDetailsNotFoundException {
       Theatre theatre= theatreRepository.findTheatreById(theatreId);
       if(theatre==null){
           throw new TheatreDetailsNotFoundException("theatre is not found for this"+theatreId);
       }
       return theatre;
    }
    public void addMoviesToTheatre(String theatreName, Movie movie){
        Theatre theatre=theatreRepository.findByTheatreName(theatreName);
        if(theatre!=null){
            movie.setTheatreId(theatre.getTheatreId());
            movieRepository.save(movie);
            theatre.getMovies().add(movie.getMovieId());
            theatreRepository.save(theatre);
        }
    }
    public List<Movie> getMoviesByTheatreName(String theatreName){
        Theatre theatre=theatreRepository.findByTheatreName(theatreName);
        if(theatre!=null){
            return movieRepository.findByTheatreId(theatre.getTheatreId());

        }
        return null;
    }

    public List<Theatre> getTheatres(){
        return theatreRepository.getTheatres();
    }
    public Theatre getTheatreName(String theatreName){
        return theatreRepository.findByName(theatreName);
    }

}
