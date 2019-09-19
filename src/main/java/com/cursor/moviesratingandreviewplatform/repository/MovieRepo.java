package com.cursor.moviesratingandreviewplatform.repository;

import com.cursor.moviesratingandreviewplatform.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, Long> {
}
