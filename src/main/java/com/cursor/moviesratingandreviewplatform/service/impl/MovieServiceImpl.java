package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.dto.MovieWithReviewDTO;
import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.exceptions.NotFoundException;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.repository.MovieRepo;
import com.cursor.moviesratingandreviewplatform.repository.ReviewRepo;
import com.cursor.moviesratingandreviewplatform.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
            Movie newMovie = new Movie();
            newMovie = movieRepo.findMovieById(movieId).orElseThrow(NotFoundException::new);
            newMovie.setName(updatedMovie.getName());
            newMovie.setCategory(updatedMovie.getCategory());
            newMovie.setDirector(updatedMovie.getDirector());
            newMovie.setRate(updatedMovie.getRate());
            newMovie.setShortDescription(updatedMovie.getShortDescription());
            return movieRepo.save(newMovie);
        } else {
            return movieRepo.save(updatedMovie);
        }
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
    public MovieWithReviewDTO getMovieWithReviews(Long movieId) {
        MovieWithReviewDTO movie = new MovieWithReviewDTO();
        movie.setMovie(movieRepo.findMovieById(movieId).orElseThrow(NotFoundException::new));
        movie.setMovieReview(reviewRepo.findAllByMovieId(movieId));
        return movie;
    }

    @Override
    public List<Movie> getAllMoviesByRate(boolean desc) {
        if (desc) {
            return movieRepo.findAll().stream()
                    .sorted(Comparator.comparing(movie -> movie.getRate().getCountOfVotes(), Comparator.reverseOrder()))
                    .collect(Collectors.toList());
        } else {
            return movieRepo.findAll().stream()
                    .sorted(Comparator.comparing(movie -> movie.getRate().getCountOfVotes()))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Movie> getMoviesByCategory(Category category) {
        return movieRepo.findAllByCategory(category);
    }

}
