package com.cursor.moviesratingandreviewplatform.service.impl;

import com.cursor.moviesratingandreviewplatform.model.Rate;
import com.cursor.moviesratingandreviewplatform.repository.MovieRepo;
import com.cursor.moviesratingandreviewplatform.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    MovieRepo movieRepo;

    @Override
    public void addRateToMovie(Long movieId, Rate rate) {

    }
}
