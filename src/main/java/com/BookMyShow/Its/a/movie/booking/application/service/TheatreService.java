package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import com.BookMyShow.Its.a.movie.booking.application.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    public Theatre addTheatre(Theatre theatre){
        return theatreRepository.save(theatre);
    }

    public List<Theatre> getTheatres(){
        return theatreRepository.getTheatres();
    }
    public Theatre getTheatre(String theatreName){
        return theatreRepository.findByName(theatreName);
    }

}
