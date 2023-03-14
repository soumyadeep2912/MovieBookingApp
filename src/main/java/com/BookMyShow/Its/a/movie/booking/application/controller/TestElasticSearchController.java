package com.BookMyShow.Its.a.movie.booking.application.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.BookMyShow.Its.a.movie.booking.application.dto.MovieDto;
import com.BookMyShow.Its.a.movie.booking.application.exception.MovieDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Es")
public class TestElasticSearchController {

    @Autowired
    ElasticsearchClient client;
    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody MovieDto movie) throws IOException {
       System.out.println(movie.toString());
       IndexResponse response = client.index(i -> i.index("movie_2").document(movie));

       return new ResponseEntity(response, HttpStatus.OK);
   }


 }


