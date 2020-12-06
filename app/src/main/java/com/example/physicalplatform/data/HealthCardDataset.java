package com.example.physicalplatform.data;

public class HealthCardDataset {
    private String name;
    private Object imagePath;

    public HealthCardDataset(String name, Object imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public Object getImagePath() {
        return imagePath;
    }
}
