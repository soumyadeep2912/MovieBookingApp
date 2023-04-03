package com.BookMyShow.Its.a.movie.booking.application.service;

import com.BookMyShow.Its.a.movie.booking.application.model.Booking;
import com.BookMyShow.Its.a.movie.booking.application.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking  createBooking(Booking booking){
        return bookingRepository.save(booking);
    }
    public List<Booking>getAllBookings(){
        return bookingRepository.findBookings();
    }
}
