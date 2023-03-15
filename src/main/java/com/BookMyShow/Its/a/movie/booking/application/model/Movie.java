package com.BookMyShow.Its.a.movie.booking.application.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Document(collection = "movies")
public class Movie {

    @Id
    private String movieId;
    private String movieName;
    private Double duration;
    private String coverPhtUrl;
    private String trailerUrl;
    private String movieDesc;
    private int rating;

    public Movie() {
    }
    public Movie(String movieId, String movieName, Double duration, String coverPhtUrl, String trailerUrl,
                 String movieDesc,int rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.coverPhtUrl = coverPhtUrl;
        this.trailerUrl = trailerUrl;
        this.movieDesc = movieDesc;
        this.rating=rating;
    }



    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getCoverPhtUrl() {
        return coverPhtUrl;
    }

    public void setCoverPhtUrl(String coverPhtUrl) {
        this.coverPhtUrl = coverPhtUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return rating == movie.rating && Objects.equals(movieId, movie.movieId) &&
               Objects.equals(movieName, movie.movieName) && Objects.equals(duration, movie.duration) &&
               Objects.equals(coverPhtUrl, movie.coverPhtUrl) && Objects.equals(trailerUrl, movie.trailerUrl) &&
               Objects.equals(movieDesc, movie.movieDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, duration, coverPhtUrl, trailerUrl, movieDesc, rating);
    }

    @Override
    public String toString() {
        return "Movie{" + "movieId='" + movieId + '\'' + ", movieName='" + movieName + '\'' + ", duration=" + duration +
               ", coverPhtUrl='" + coverPhtUrl + '\'' + ", trailerUrl='" + trailerUrl + '\'' + ", movieDesc='" +
               movieDesc + '\'' + ", rating=" + rating + '}';
    }
}
