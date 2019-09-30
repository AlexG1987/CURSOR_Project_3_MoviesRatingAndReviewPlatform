package com.cursor.moviesratingandreviewplatform.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class Rate {

    private int countOfVotes;

    @Range(min = 1, max = 10)
    private double rate;

}
