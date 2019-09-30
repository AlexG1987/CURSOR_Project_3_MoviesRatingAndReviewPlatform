package com.cursor.moviesratingandreviewplatform.repository;

import com.cursor.moviesratingandreviewplatform.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepo extends MongoRepository<Review, Long> {

    List<Review> findAllByMovieId (Long movieId);

}
