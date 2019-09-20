package com.cursor.moviesratingandreviewplatform.service;

import com.cursor.moviesratingandreviewplatform.model.Review;

public interface ReviewService{

    void addReviewToMovie(Long movieId, Review review);

}
