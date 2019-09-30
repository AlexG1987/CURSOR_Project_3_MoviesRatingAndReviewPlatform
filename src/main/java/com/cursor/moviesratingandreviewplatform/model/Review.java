package com.cursor.moviesratingandreviewplatform.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Review {

    @Id
    private long id;

    private long movieId;

    private String reviewMessage;

    private boolean isLiked;

}
