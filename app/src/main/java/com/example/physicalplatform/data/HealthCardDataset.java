package com.example.physicalplatform.data;

public class HealthCardDataset {
    private String name;
    private String info;
    private Object imagePath;
    private String[] videoNameList;

    public HealthCardDataset(String name, String info, Object imagePath, String[] videoNameList) {
        this.name = name;
        this.info = info;
        this.imagePath = imagePath;
        this.videoNameList = videoNameList;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public Object getImagePath() {
        return imagePath;
    }

    public String[] getVideoNameList() {
        return videoNameList;
    }
}
