package com.BookMyShow.Its.a.movie.booking.application.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "theatres")
public class Theatre {

    @Id
    private ObjectId _id;
    private String name;
    private int screenCount;
    private String city;
    private String address;
    private ArrayList<String> movieScreening;

    public ObjectId get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return "Theatre{" + "_id=" + _id + ", name='" + name + '\'' + ", screenCount=" + screenCount + ", city='" +
               city + '\'' + ", address='" + address + '\'' + ", movieScreening=" + movieScreening + '}';
    }

    public Theatre() {
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
