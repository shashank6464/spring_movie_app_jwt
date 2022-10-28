package com.spring.jwt.mongo.Spring_Movie_App_Jwt.controller;

import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.Movie;
import com.spring.jwt.mongo.Spring_Movie_App_Jwt.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //Adding a movie
    @PostMapping("/addMovie")
    public String saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    //Get all movies
    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

}
