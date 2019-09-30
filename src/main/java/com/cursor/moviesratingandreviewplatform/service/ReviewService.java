package com.cursor.moviesratingandreviewplatform.service;

import com.cursor.moviesratingandreviewplatform.model.Review;

import java.util.List;

public interface ReviewService{

    void addReviewToMovie(Review review);

    Review updateReview(Long reviewId, Review updatedReview);

    List<Review> findAllByMovieId(Long movieId);

}
