package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.exceptions.NotFoundException;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.repository.MovieRepo;
import com.cursor.moviesratingandreviewplatform.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Movie updateMovie(Long movieId, Movie updatedMovie) {
        Movie newMovie = new Movie();
        newMovie = movieRepo.findMovieById(movieId).orElseThrow(NotFoundException::new);
        newMovie.setName(updatedMovie.getName());
        newMovie.setCategory(updatedMovie.getCategory());
        newMovie.setDirector(updatedMovie.getDirector());
        newMovie.setRateValue(updatedMovie.getRateValue());
        newMovie.setShortDescription(updatedMovie.getShortDescription());
        return newMovie;
    }

    @Override
    public Movie addRateToMovie(Long movieId, Rate rate) {
        Movie existingMovie = new Movie();
        existingMovie = movieRepo.findById(movieId).orElseThrow(NotFoundException::new);
        Rate movieRate = existingMovie.getRate();
        movieRate.setRate(movieRate.getRate() + 1);
        movieRate.setCountOfVotes(movieRate.getCountOfVotes() + 1);
        return existingMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public List<Movie> getAllMoviesByRate() {
        return movieRepo.findAllByRateValue().stream()
                .sorted(Comparator.comparing(Movie::getRateValue).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesByCategory(Category category) {
        return movieRepo.findAllByCategory(category);
    }

}
