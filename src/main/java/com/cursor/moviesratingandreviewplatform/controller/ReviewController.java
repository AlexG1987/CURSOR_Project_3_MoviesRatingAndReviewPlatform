package com.cursor.moviesratingandreviewplatform.controller;

import com.cursor.moviesratingandreviewplatform.model.Review;
import com.cursor.moviesratingandreviewplatform.service.impl.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @PutMapping("/review/movie/{id}")
    public ResponseEntity addReview(@RequestBody Review review, @PathVariable(name = "id") Long id) {
        reviewService.addReviewToMovie(id, review);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
