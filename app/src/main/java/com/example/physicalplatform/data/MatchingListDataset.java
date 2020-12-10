package com.example.physicalplatform.data;

public class MatchingListDataset {
    private boolean isRegistered;           // 신청한 강의 여부
    private boolean isAlmost;               // 마감임박 여부
    private boolean isStar;                 // 인기강의 여부
    private String listTitle;               // 강의 제목
    private String location;                // 강의 장소
    private String period;                  // 강의 주기
    private String classTime;               // 강의 시간

    public MatchingListDataset(boolean isRegistered, boolean isAlmost, boolean isStar, String listTitle, String location, String period, String classTime) {
        this.isRegistered = isRegistered;
        this.isAlmost = isAlmost;
        this.isStar = isStar;
        this.listTitle = listTitle;
        this.location = location;
        this.period = period;
        this.classTime = classTime;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public boolean isAlmost() {
        return isAlmost;
    }

    public boolean isStar() {
        return isStar;
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

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}
