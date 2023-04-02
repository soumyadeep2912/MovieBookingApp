package com.BookMyShow.Its.a.movie.booking.application.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import com.BookMyShow.Its.a.movie.booking.application.dto.MovieDto;
import com.BookMyShow.Its.a.movie.booking.application.exception.MovieDetailsNotFoundException;
import com.BookMyShow.Its.a.movie.booking.application.model.Movie;
import com.BookMyShow.Its.a.movie.booking.application.service.MovieService;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/Es")
public class TestElasticSearchController {

    @Autowired
    ElasticsearchClient client;

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    private RestClient restClient;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;
    @PostMapping("/add")
    public String addMovie(@RequestBody MovieDto movie) throws IOException {
       System.out.println(movie.toString());
       IndexResponse response = client.index(i -> i.index("movie_2").document(movie));

       return "added";
   }
   @GetMapping("/{movieName}")
   public  String getMovie(@PathVariable String movieName) throws IOException {
      SearchResponse searchResponse=  client.search(s->s.index("movie_2")
                                                     .query(q->q
                                                               .term(t->t
                                                                       .field("movie_name.keyword").value(v->v.stringValue(movieName)))),
               MovieDto.class);

       System.out.println(searchResponse.hits().hits().toString());
        return "getting this movie";
   }


   @PostMapping("/load-to-elastic-search")
   public String loadToElasticSearch() throws IOException {
        List<Movie>movies=mongoTemplate.findAll(Movie.class);
    BulkRequest.Builder br = new BulkRequest.Builder();

    for (Movie movie : movies){
        br.operations(op -> op
                .index(idx -> idx
                        .index("movie_2")
                        .id(movie.getMovieId())
                        .document(movie)
                )
        );
    }
    BulkResponse result = client.bulk(br.build());
    if (result.errors()) {
        System.out.println("Bulk had errors");
        for (BulkResponseItem item: result.items()) {
            if (item.error() != null) {
                System.out.println(item.error().reason());
            }
        }
    }
    return "loaded";

    }





 }


