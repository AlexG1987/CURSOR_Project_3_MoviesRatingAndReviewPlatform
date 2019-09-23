package com.cursor.moviesratingandreviewplatform.service;

import com.cursor.moviesratingandreviewplatform.dto.MovieDto;
import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.model.Review;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    void addMovie(MovieDto movie);

    Optional<MovieDto> getMovieById(Long movieId);

    void deleteMovieById(Long movieId);

    MovieDto updateMovie(Long movieId, MovieDto updatedMovie);

    Movie addRateToMovie(Long movieId, Rate rate);

    Movie addReviewToMovie(Long movieId, Review review);

    List<MovieDto> getAllMovies();

    List<MovieDto> getAllMoviesByRate();

    List<MovieDto> getMoviesByCategory(Category category);

}
