package com.cursor.moviesratingandreviewplatform.service;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Review;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    void addMovie(Movie movie);

    Optional<Movie> getMovieById(Long movieId);

    void deleteMovieById(Long movieId);

    void updateMovie(Long movieId, Movie updatedMovie);

    Movie addReviewToMovie(Long movieId, Review review);

    List<Movie> getAllMovies();

    List<Movie> getAllMoviesByRate(boolean hiLo);

    List<Movie> getMoviesByCategory(Category category);

}
