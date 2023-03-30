package com.BookMyShow.Its.a.movie.booking.application.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "theatres")
public class Theatre {

    @Id
    private String theatreId;
    private String name;
    private int screenCount;
    private String city;
    private String address;
    private ArrayList<String> movieScreening;
    private List<String>movies=new ArrayList<>();


    public Theatre(String theatreId, String name, int screenCount, String city, String address,
                   ArrayList<String> movieScreening, List<String> movies) {
        this.theatreId = theatreId;
        this.name = name;
        this.screenCount = screenCount;
        this.city = city;
        this.address = address;
        this.movieScreening = movieScreening;
        this.movies = movies;
    }

    public Theatre() {
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

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Theatre{" + "theatreId='" + theatreId + '\'' + ", name='" + name + '\'' + ", screenCount=" +
               screenCount + ", city='" + city + '\'' + ", address='" + address + '\'' + ", movieScreening=" +
               movieScreening + ", movies=" + movies + '}';
    }
}
