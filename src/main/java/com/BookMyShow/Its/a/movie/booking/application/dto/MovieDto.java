package com.BookMyShow.Its.a.movie.booking.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDto {

    @JsonProperty("movie_id")
    private String movieId;
    @JsonProperty("movie_name")
    private String movieName;
    @JsonProperty("duration")
    private Double duration;
    @JsonProperty("cover_pht_url")
    private String coverPhtUrl;
    @JsonProperty("trailer_url")
    private String trailerUrl;
    @JsonProperty("movie_desc")
    private String movieDesc;
    @JsonProperty("rating")
    private int rating;

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
    public String toString() {
        return "MovieDto{" + "movieId='" + movieId + '\'' + ", movieName='" + movieName + '\'' + ", duration=" +
               duration + ", coverPhtUrl='" + coverPhtUrl + '\'' + ", trailerUrl='" + trailerUrl + '\'' +
               ", movieDesc='" + movieDesc + '\'' + ", rating=" + rating + '}';
    }
}
