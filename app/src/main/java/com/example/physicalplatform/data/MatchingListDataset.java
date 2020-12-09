package com.example.physicalplatform.data;

//private String email;                   // 유저 이메일
//private Integer numOfRegistered;        // 신청한 강의
//private Integer numOfAlmost;            // 마감 임박
//private Integer numOfStar;              // 즐겨찾기

public class MatchingListDataset {
    private boolean isSelected;
    private String listTitle;               // 강의 제목
    private String location;                // 강의 장소
    private String period;                  // 강의 주기
    private String classTime;               // 강의 시간

    public MatchingListDataset(boolean isSelected, String listTitle, String location, String period, String classTime) {
        this.isSelected = isSelected;
        this.listTitle = listTitle;
        this.location = location;
        this.period = period;
        this.classTime = classTime;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getListTitle() {
        return listTitle;
    }

    public String getLocation() {
        return location;
    }

    public String getPeriod() {
        return period;
    }

    public String getClassTime() {
        return classTime;
    }
}
