package com.BookMyShow.Its.a.movie.booking.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class TheatreDto {
    @JsonProperty("theatre_id")
    private ObjectId _id;
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

    public ObjectId get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return "Theatre{" + "_id=" + _id + ", name='" + name + '\'' + ", screenCount=" + screenCount + ", city='" +
               city + '\'' + ", address='" + address + '\'' + ", movieScreening=" + movieScreening + '}';
    }



    public void set_id(ObjectId _id) {
        this._id = _id;
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
