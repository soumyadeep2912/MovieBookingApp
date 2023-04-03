package com.BookMyShow.Its.a.movie.booking.application.repository;

import com.BookMyShow.Its.a.movie.booking.application.model.Booking;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public Booking save(Booking booking){
        mongoTemplate.save(booking);
        return booking;
    }
    public List<Booking>findBookings(){
        return mongoTemplate.findAll(Booking.class);
    }


}
