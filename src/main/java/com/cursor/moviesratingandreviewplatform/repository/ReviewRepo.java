package com.cursor.moviesratingandreviewplatform.repository;

import com.cursor.moviesratingandreviewplatform.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepo extends MongoRepository<Review, Long> {
}
