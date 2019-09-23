package com.cursor.moviesratingandreviewplatform.controller;

import com.cursor.moviesratingandreviewplatform.enums.Category;
import com.cursor.moviesratingandreviewplatform.model.Movie;
import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieService;

    @PostMapping("/admin/movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/admin/movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable(name = "id") Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PatchMapping("/movie/{id}")
    public ResponseEntity addRateToMovie(@PathVariable(name = "id") Long id, @RequestBody Rate rate) {
        movieService.addRateToMovie(id, rate);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PatchMapping("/admin/movie/{id}")
    public ResponseEntity editMovie(@PathVariable(name = "id") Long id, @RequestBody Movie newMovie) {
        movieService.updateMovie(id, newMovie);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @ResponseBody
    @GetMapping("/movie/{id}")
    public Optional<Movie> getMovieById(@PathVariable(name = "id") Long id) {
        return movieService.getMovieById(id);
    }

    @ResponseBody
    @GetMapping("/movie/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @ResponseBody
    @GetMapping("/stats/rate")
    public List<Movie> getMovieByRating() {
        return movieService.getAllMoviesByRate();
    }

    @ResponseBody
    @GetMapping("/stats/{category}")
    public List<Movie> getMovieByCategory(@PathVariable(name = "category") Category category) {
        return movieService.getMoviesByCategory(category);
    }

}
