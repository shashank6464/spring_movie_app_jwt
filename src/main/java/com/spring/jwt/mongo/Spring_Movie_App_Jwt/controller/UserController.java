package com.spring.jwt.mongo.Spring_Movie_App_Jwt.controller;

import com.spring.jwt.mongo.Spring_Movie_App_Jwt.model.User;
import com.spring.jwt.mongo.Spring_Movie_App_Jwt.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Adding a user
    @PostMapping(value = "/addUser")
    public String signup(@RequestBody User user){
        return userService.signup(user);
    }

    //User login using email and password as input
    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> map){
        return userService.login(map.get("email").toString(), map.get("password").toString());
    }


    //Get a user
    @GetMapping("/getUser")
    public User getUser(HttpServletRequest request){
        ObjectId userId = (ObjectId) request.getAttribute("userId");
        return userService.getUser(userId);
    }

    //Get all users
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(HttpServletRequest request){
        return userService.getAllUsers();
    }


}
