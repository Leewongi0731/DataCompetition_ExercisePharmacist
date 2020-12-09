package com.example.physicalplatform.data;

public class HealthVideoDataset {
    String videoName;
    String videoURL;
    String videoRunTime;

    public HealthVideoDataset(String videoName, String videoURL, String videoRunTime) {
        this.videoName = videoName;
        this.videoURL = videoURL;
        this.videoRunTime = videoRunTime;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getVideoRunTime() {
        return videoRunTime;
    }
}
