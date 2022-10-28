package com.spring.jwt.mongo.Spring_Movie_App_Jwt.service;

import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.Movie;
import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.User;
import com.spring.jwt.mongo.Spring_Movie_App_Jwt.repository.MovieRepository;
import com.spring.jwt.mongo.Spring_Movie_App_Jwt.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    private MovieRepository movieRepository;
    private TokenService tokenService;

    @Autowired
    public MovieService(MovieRepository movieRepository, TokenService tokenService) {
        this.movieRepository = movieRepository;
        this.tokenService = tokenService;
    }


    //Save movie
    public String saveMovie(Movie movie){
        Movie savedMovie = movieRepository.save(movie);

        return "{" +
                "\"message\":"+"\"Successfully added Movie\",\n"+
                "\"data\":"+savedMovie+",\n"+
                "}";
    }

    //get all movies
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }




}
