package com.cursor.moviesratingandreviewplatform.service;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    void addMovie(Movie movie);

    Optional<Movie> getMovieById(Long movieId);

    void deleteMovieById(Long movieId);

    Movie updateMovie(Long movieId, Movie updatedMovie);

    Movie addRateToMovie(Long movieId, Rate rate);

    List<Movie> getAllMovies();

    List<Movie> getAllMoviesByRate();

    List<Movie> getMoviesByCategory(Category category);

}
