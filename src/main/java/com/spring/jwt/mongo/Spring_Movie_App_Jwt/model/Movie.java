package com.spring.jwt.mongo.Spring_Movie_App_Jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private String name;
    private Date releaseDate;

//    public Movie(String name, Date releaseDate) {
//        this.name = name;
//        this.releaseDate = releaseDate;
//    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
