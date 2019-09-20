package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.model.Review;
import com.cursor.moviesratingandreviewplatform.repository.ReviewRepo;
import com.cursor.moviesratingandreviewplatform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    ReviewRepo reviewRepo;

    @Override
    public void addReviewToMovie(Long movieId, Review review) {
        reviewRepo.save(review);
    }
}
