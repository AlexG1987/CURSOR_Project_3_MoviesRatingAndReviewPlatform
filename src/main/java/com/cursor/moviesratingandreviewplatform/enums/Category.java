package com.cursor.moviesratingandreviewplatform.enums;

public enum Category {

    SCI_FI("Science fiction"),

    ADV("Adventure"),

    ACT("Action"),

    DRM("Drama"),

    COM("Comedy"),

    THR("Thriller"),

    HOR("Horror"),

    ROM("Romantic"),

    DOC("Documentary"),

    FAN("Fantasy"),

    OTH("Other");

    private final String label;

    private Category(String label){
        this.label = label;
    }

}
