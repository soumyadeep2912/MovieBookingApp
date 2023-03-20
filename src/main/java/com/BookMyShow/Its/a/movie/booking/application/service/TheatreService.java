package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import com.BookMyShow.Its.a.movie.booking.application.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    public Theatre addTheatre(Theatre theatre){
        return theatreRepository.save(theatre);
    }

}
