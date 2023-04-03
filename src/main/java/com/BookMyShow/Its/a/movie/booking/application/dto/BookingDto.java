package com.BookMyShow.Its.a.movie.booking.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class BookingDto {
    @JsonProperty("booking_id")
    private String bookingId;
    @JsonProperty("booking_date")
    private LocalDateTime bookingDate;
    @JsonProperty("no_of_seats")
    private int noOfSeats;

    public BookingDto() {
    }

    public BookingDto(String bookingId, LocalDateTime bookingDate, int noOfSeats) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.noOfSeats = noOfSeats;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @Override
    public String toString() {
        return "BookingDto{" + "bookingId='" + bookingId + '\'' + ", bookingDate=" + bookingDate + ", noOfSeats=" +
               noOfSeats + '}';
    }
}
