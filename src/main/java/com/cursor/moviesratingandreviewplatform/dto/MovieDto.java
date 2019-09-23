package com.cursor.moviesratingandreviewplatform.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class MovieDto {

    @Id
    private long id;

    private String name;

    private String category;

    private String director;

    private String shortDescription;

    private int rateValue;

}
