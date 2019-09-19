package com.cursor.moviesratingandreviewplatform.model;

import lombok.Data;

@Data
public class Review {

    private long movie_id;

    private String review_message;

    private boolean like;

}
