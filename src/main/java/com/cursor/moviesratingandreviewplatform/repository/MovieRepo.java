package com.cursor.moviesratingandreviewplatform.repository;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends MongoRepository<Movie, Long> {

    @Query("{'rate.rate_value': {$eq:?0}}")
    List<Movie> findAllByRateValue();

    @Query("{'category.genre': ?0}")
    List<Movie> findAllByCategory(Category category);

    Optional<Movie> findMovieById(Long id);

}
