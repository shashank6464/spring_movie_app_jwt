package com.spring.jwt.mongo.Spring_Movie_App_Jwt.repository;

import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    //Additional Query added
    @Query("{email:\"?0\"}")
    List<User> getUsersByEmail(String email);

}
