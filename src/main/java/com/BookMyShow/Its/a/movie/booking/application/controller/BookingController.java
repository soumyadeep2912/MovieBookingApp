package com.BookMyShow.Its.a.movie.booking.application.controller;

import com.BookMyShow.Its.a.movie.booking.application.dto.BookingDto;
import com.BookMyShow.Its.a.movie.booking.application.dto.MovieDto;
import com.BookMyShow.Its.a.movie.booking.application.model.Booking;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
    @PostMapping("/created")
    public ResponseEntity createBookingDetails(@RequestBody BookingDto bookingDto){
  Booking bookingEntity=convertBookingDtoToEntity(bookingDto);
  Booking savedEntity=bookingService.createBooking(bookingEntity);
  BookingDto responseBody=convertEntityToBookingDto(savedEntity);
  return new ResponseEntity(responseBody, HttpStatus.CREATED);

    }
    @GetMapping("/get-all")
    public ResponseEntity getAllMovies(){
        List<Booking> allBooking=bookingService.getAllBookings();
        List<BookingDto>allBookingDto=new ArrayList<>();
        for(Booking  booking: allBooking){
            BookingDto bookingDto=convertEntityToBookingDto(booking);
            allBookingDto.add(bookingDto);
        }
        return new ResponseEntity(allBookingDto,HttpStatus.OK);
    }
    private Booking convertBookingDtoToEntity(BookingDto bookingDto){
        Booking booking=new Booking();
        booking.setBookingId(bookingDto.getBookingId());
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setNoOfSeats(bookingDto.getNoOfSeats());
        return booking;
    }
    private BookingDto convertEntityToBookingDto(Booking booking){
        BookingDto bookingDto=new BookingDto();
        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setBookingDate(booking.getBookingDate());
        bookingDto.setNoOfSeats(booking.getNoOfSeats());
        return bookingDto;
    }
}
