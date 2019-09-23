package com.cursor.moviesratingandreviewplatform.model;

import lombok.Data;

@Data
public class Review {

    private long id;

    private long movieId;

    private String reviewMessage;

    private boolean isLiked;

}
