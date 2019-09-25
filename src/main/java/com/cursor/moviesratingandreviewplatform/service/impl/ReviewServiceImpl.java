package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.exceptions.NotFoundException;
import com.cursor.moviesratingandreviewplatform.model.Review;
import com.cursor.moviesratingandreviewplatform.repository.ReviewRepo;
import com.cursor.moviesratingandreviewplatform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    public void addReviewToMovie(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public Review updateReview(Long reviewId, Review updatedReview) {
        if (reviewRepo.existsById(reviewId)) {
            reviewRepo.deleteById(reviewId);
            Review newReview = new Review();
            newReview = reviewRepo.findById(reviewId).orElseThrow(NotFoundException::new);
            newReview.setReviewMessage(updatedReview.getReviewMessage());
            newReview.setLiked(updatedReview.isLiked());
            return reviewRepo.save(newReview);
        } else {
            return reviewRepo.save(updatedReview);
        }
    }


        @Override
        public List<Review> findAllByMovieId (Long movieId){
            return reviewRepo.findAllByMovieId(movieId);
        }

    }
