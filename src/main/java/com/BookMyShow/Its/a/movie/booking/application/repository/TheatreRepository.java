package com.BookMyShow.Its.a.movie.booking.application.repository;

import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class TheatreRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    public Theatre save(Theatre theatre){
        mongoTemplate.save(theatre);
        return theatre;
    }
    public Theatre findTheatreById(String theatreId){
        return mongoTemplate.findById(theatreId, Theatre.class);
    }
    public Theatre findByTheatreName(String theatreName){
        Query query =new Query();
        query.addCriteria(Criteria.where("name").is(theatreName));
        Theatre theatre=mongoTemplate.findOne(query, Theatre.class);
        return theatre;


    }
}
