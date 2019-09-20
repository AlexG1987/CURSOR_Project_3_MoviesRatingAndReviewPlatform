package com.cursor.moviesratingandreviewplatform.service;

import com.cursor.moviesratingandreviewplatform.model.Rate;

public interface RateService {

    void addRateToMovie(Long movieId, Rate rate);

}
