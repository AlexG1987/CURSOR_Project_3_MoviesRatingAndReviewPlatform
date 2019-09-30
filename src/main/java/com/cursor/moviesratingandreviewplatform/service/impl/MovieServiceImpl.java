package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.dto.MovieWithReviewDTO;
import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.exceptions.NotFoundException;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.model.Review;
import com.cursor.moviesratingandreviewplatform.repository.MovieRepo;
import com.cursor.moviesratingandreviewplatform.repository.ReviewRepo;
import com.cursor.moviesratingandreviewplatform.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;
    private final ReviewRepo reviewRepo;

    @Override
    public void addMovie(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public Movie updateMovie(Long movieId, Movie updatedMovie) {
        if (movieRepo.existsById(movieId)) {
            movieRepo.deleteById(movieId);
            updatedMovie.setId(movieId);
            return movieRepo.save(updatedMovie);
        } else {
            return movieRepo.save(updatedMovie);
        }
    }

    @Override
    public Movie addRateToMovie(Long movieId, Rate rate) {
        Movie existingMovie = movieRepo.findById(movieId).orElseThrow(NotFoundException::new);
        Rate movieRate = existingMovie.getRate();
        movieRate.setRate(movieRate.getRate());
        movieRate.setCountOfVotes(movieRate.getCountOfVotes() + 1);
        return existingMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public MovieWithReviewDTO getMovieWithReviews(Long movieId) {
        Movie movie = movieRepo.findMovieById(movieId).orElseThrow(NotFoundException::new);
        List<Review> reviews = reviewRepo.findAllByMovieId(movieId);
        return new MovieWithReviewDTO(movie, reviews);
    }

    @Override
    public List<Movie> getAllMoviesByRate(boolean isDescOrder) {
        if (isDescOrder) {
            List<Movie> sortedMovies = movieRepo.findAll();
            Collections.reverse(sortedMovies);
            return sortedMovies;
        } else {
            return movieRepo.findAll();
        }
    }

    @Override
    public List<Movie> getMoviesByCategory(Category category) {
        return movieRepo.findAllByCategory(category);
    }

}
