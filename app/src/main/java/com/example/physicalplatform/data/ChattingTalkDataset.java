package com.example.physicalplatform.data;

public class ChattingTalkDataset {
    private Integer imageSrc;
    private boolean isMine;
    private String name;
    private String contents;
    private String date;

    public ChattingTalkDataset(Integer imageSrc, boolean isMine, String name, String contents, String date) {
        this.imageSrc = imageSrc;
        this.isMine = isMine;
        this.name = name;
        this.contents = contents;
        this.date = date;
    }

    public Integer getImageSrc() {
        return imageSrc;
    }

    public boolean isMine() {
        return isMine;
    }

    public String getName() {
        return name;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }
}
