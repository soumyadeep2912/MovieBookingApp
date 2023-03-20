package com.BookMyShow.Its.a.movie.booking.application.repository;

import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class TheatreRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    public Theatre save(Theatre theatre){
        mongoTemplate.save(theatre);
        return theatre;
    }
}
