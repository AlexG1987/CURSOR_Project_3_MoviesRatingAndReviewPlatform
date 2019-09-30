package com.cursor.moviesratingandreviewplatform.repository;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends MongoRepository<Movie, Long> {

    List<Movie> findAllByCategory(Category category);

    Optional<Movie> findMovieById(Long id);

}
