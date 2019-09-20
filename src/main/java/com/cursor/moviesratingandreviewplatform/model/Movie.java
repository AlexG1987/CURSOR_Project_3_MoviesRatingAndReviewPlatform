package com.cursor.moviesratingandreviewplatform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Movie {

    @Id
    private long id;

    private String name;

    private String category;

    private String director;

    private String Description;

    private Rate rate;

    private List<Review> reviewList;

}
