package com.example.physicalplatform.data;

public class HealthCardDataset {
    private String name;
    private Object imagePath;
    private String videoURL;

    public HealthCardDataset(String name, Object imagePath, String videoURL) {
        this.name = name;
        this.imagePath = imagePath;
        this.videoURL = videoURL;
    }

    public String getName() {
        return name;
    }

    public Object getImagePath() {
        return imagePath;
    }

    public String getVideoURL() {
        return videoURL;
    }
}
