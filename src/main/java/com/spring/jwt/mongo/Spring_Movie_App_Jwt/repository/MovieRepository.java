package com.spring.jwt.mongo.Spring_Movie_App_Jwt.repository;

import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.Movie;
import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
