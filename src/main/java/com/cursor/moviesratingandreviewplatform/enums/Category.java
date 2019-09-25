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

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static Category fromString(String text) {
        for (Category c : Category.values()) {
            if (c.getCategory().equalsIgnoreCase(text)) {
                return c;
            }
        }
        return Category.OTH;
    }

}
