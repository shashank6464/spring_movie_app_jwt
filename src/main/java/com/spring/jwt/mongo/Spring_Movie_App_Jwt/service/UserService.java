package com.spring.jwt.mongo.Spring_Movie_App_Jwt.service;

import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.User;
import com.spring.jwt.mongo.Spring_Movie_App_Jwt.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }


    public User getUser(ObjectId id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(optionalUser::get);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //User signup
    public String signup(User user){

        User savedUser = userRepository.save(user);
        return "{" + "\"message\":"+
                "\"User Created Successfully\","+
                "\"data\": "
                +savedUser+", "+
                "\"auth token\":\""+
                "\"}";
    }

    //User login using email and password
    public String login(String email, String password){
        List<User> foundUsers = userRepository.getUsersByEmail(email);

        if(foundUsers.isEmpty()){
            return "{\n" +
                    "\"message\":"+
                    "\" Authentication Failed  \",\n"+
                    "}";
        }

        else if(!foundUsers.get(0).getPassword().equals(password)){
            return "{\n" +
                    "\"message\":"+
                    "\" Incorrect Password (Try Again)\",\n"+
                    "}";
        }
        return "{\n" +
                "\"message\":"+
                "\" User Successfully Logged In\",\n"+
                "\"data\": {\n"+
                " Name : "+foundUsers.get(0).getName()+",\n"+
                "Email : "+foundUsers.get(0).getEmail()+"\n"+
                "\"token\":\""+tokenService.createToken(foundUsers.get(0).getId())+"\"" +
                "}";

    }


}
