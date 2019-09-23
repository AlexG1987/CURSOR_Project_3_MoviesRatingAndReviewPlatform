package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.dto.MovieDto;
import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.exceptions.NotFoundException;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.model.Review;
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
    public void addMovie(MovieDto movie) {
        movieRepo.save(movie);
    }

    @Override
    public Optional<MovieDto> getMovieById(Long movieId) {
        return movieRepo.findById(movieId);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public MovieDto updateMovie(Long movieId, MovieDto updatedMovie) {
        MovieDto newMovie = new MovieDto();
        newMovie = movieRepo.findById(movieId).orElseThrow(NotFoundException::new);
        newMovie.setName(updatedMovie.getName());
        newMovie.setCategory(updatedMovie.getCategory());
        newMovie.setDirector(updatedMovie.getDirector());
        newMovie.setRateValue(updatedMovie.getRateValue());
        newMovie.setShortDescription(updatedMovie.getShortDescription());
        return newMovie;
    }

    @Override
    public Movie addRateToMovie(Long movieId, Rate rate) {
        return null;
    }

    @Override
    public Movie addReviewToMovie(Long movieId, Review review) {
        return null;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public List<MovieDto> getAllMoviesByRate() {
        return movieRepo.findAllByRateValue().stream()
                .sorted(Comparator.comparing(MovieDto::getRateValue).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getMoviesByCategory(Category category) {
        return movieRepo.findAllByCategory(category);
    }

}
