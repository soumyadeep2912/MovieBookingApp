package com.BookMyShow.Its.a.movie.booking.application.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String userId;

    private String userName;
    private String firstName;
    private String lastName;
    private String city;
    private String emailId;
    private String mobileNumber;
}
