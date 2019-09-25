package com.cursor.moviesratingandreviewplatform.dto;

import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Review;
import lombok.Data;

import java.util.List;

@Data
public class MovieWithReviewDTO {

    private Movie movie;

    private List<Review> movieReview;

}
