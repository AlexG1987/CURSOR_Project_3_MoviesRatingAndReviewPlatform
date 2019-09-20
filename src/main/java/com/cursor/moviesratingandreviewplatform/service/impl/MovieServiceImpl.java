package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Review;
import com.cursor.moviesratingandreviewplatform.repository.MovieRepo;
import com.cursor.moviesratingandreviewplatform.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    MovieRepo movieRepo;

    @Override
    public void addMovie(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(Long movieId) {
        return movieRepo.findById(movieId);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public void updateMovie(Long movieId, Movie updatedMovie) {
        if (movieRepo.existsById(movieId))
            movieRepo.deleteById(movieId);
        movieRepo.save(updatedMovie);
    }

    @Override
    public Movie addReviewToMovie(Long movieId, Review review) {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public List<Movie> getAllMoviesByRate(boolean hiLo) {
        return movieRepo.findAllByRate();
    }

    @Override
    public List<Movie> getMoviesByCategory(Category category) {
        return movieRepo.findAllByCategory(category);
    }
}
