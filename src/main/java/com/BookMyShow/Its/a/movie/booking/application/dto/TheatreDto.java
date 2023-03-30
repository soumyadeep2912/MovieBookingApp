package com.BookMyShow.Its.a.movie.booking.application.dto;

import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class TheatreDto {
    @JsonProperty("theatre_id")
    private String theatreId;
    @JsonProperty("theatre_name")
    private String name;
    @JsonProperty("movies_onscreen")
    private int screenCount;

    @JsonProperty("city")
    private String city;

    @JsonProperty("theatre_address")
    private String address;

    @JsonProperty("movie_list")
    private ArrayList<String> movieScreening;
    @JsonProperty("movies")
    private List<String> movies=new ArrayList<>();

    @Override
    public String toString() {
        return "TheatreDto{" + "theatreId='" + theatreId + '\'' + ", name='" + name + '\'' + ", screenCount=" +
               screenCount + ", city='" + city + '\'' + ", address='" + address + '\'' + ", movieScreening=" +
               movieScreening + ", movies=" + movies + '}';
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScreenCount() {
        return screenCount;
    }

    public void setScreenCount(int screenCount) {
        this.screenCount = screenCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getMovieScreening() {
        return movieScreening;
    }

    public void setMovieScreening(ArrayList<String> movieScreening) {
        this.movieScreening = movieScreening;
    }

}
