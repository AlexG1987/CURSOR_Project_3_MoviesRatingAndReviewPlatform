package com.cursor.moviesratingandreviewplatform.repository;

import com.cursor.moviesratingandreviewplatform.dto.MovieDto;
import com.cursor.moviesratingandreviewplatform.enums.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepo extends MongoRepository<MovieDto, Long> {

    List<MovieDto> findAllByRateValue();

    List<MovieDto> findAllByCategory(Category category);



}
