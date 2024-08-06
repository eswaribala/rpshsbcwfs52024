package com.hsbc.models;

public class CD {

    private String title;
    private String singer;

    public CD() {
    }

    public CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "CD{" +
                "title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }
}
