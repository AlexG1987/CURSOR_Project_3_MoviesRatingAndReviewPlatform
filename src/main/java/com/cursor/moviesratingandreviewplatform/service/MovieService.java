package com.cursor.moviesratingandreviewplatform.service;

import com.cursor.moviesratingandreviewplatform.dto.MovieWithReviewDTO;
import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;

import java.util.List;

public interface MovieService {

    void addMovie(Movie movie);

    void deleteMovieById(Long movieId);

    Movie updateMovie(Long movieId, Movie updatedMovie);

    Movie addRateToMovie(Long movieId, Rate rate);

    List<Movie> getAllMovies();

    MovieWithReviewDTO getMovieWithReviews(Long movieId);

    List<Movie> getAllMoviesByRate(boolean desc);

    List<Movie> getMoviesByCategory(Category category);

}
