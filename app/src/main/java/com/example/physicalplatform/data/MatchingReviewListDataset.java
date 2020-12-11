package com.example.physicalplatform.data;

public class MatchingReviewListDataset {
    private String imageSrc;
    private String name;
    private String contents;
    private Double rating;
    private String date;

    public MatchingReviewListDataset(String imageSrc, String name, String contents, Double rating, String date) {
        this.imageSrc = imageSrc;
        this.name = name;
        this.contents = contents;
        this.rating = rating;
        this.date = date;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getName() {
        return name;
    }

    public String getContents() {
        return contents;
    }

    public Double getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }
}
