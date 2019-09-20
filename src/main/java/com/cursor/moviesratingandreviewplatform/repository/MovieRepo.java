package com.cursor.moviesratingandreviewplatform.repository;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepo extends MongoRepository<Movie, Long> {

    List<Movie> findAllByRate();

    List<Movie> findAllByCategory(Category category);



}
