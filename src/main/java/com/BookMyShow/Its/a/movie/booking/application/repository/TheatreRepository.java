package com.BookMyShow.Its.a.movie.booking.application.repository;

import com.BookMyShow.Its.a.movie.booking.application.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    public Theatre save(Theatre theatre){
        mongoTemplate.save(theatre);
        return theatre;
    }
    public List<Theatre> getTheatres(){
        return mongoTemplate.findAll(Theatre.class);
    }
    public Theatre findByName(String theatreName){

        Query query=new Query();
        query.addCriteria(Criteria.where("theatre_name").is(theatreName));
        return mongoTemplate.findOne(query, Theatre.class);
    }

}
