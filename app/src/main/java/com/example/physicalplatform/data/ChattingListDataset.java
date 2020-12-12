package com.example.physicalplatform.data;

public class ChattingListDataset {
    private Integer profileSrc;
    private String opponentName;
    private String recentTalk;
    private Integer beforeTime;
    private Integer numOfChat;

    public ChattingListDataset(Integer profileSrc, String opponentName, String recentTalk, Integer beforeTime, Integer numOfChat) {
        this.profileSrc = profileSrc;
        this.opponentName = opponentName;
        this.recentTalk = recentTalk;
        this.beforeTime = beforeTime;
        this.numOfChat = numOfChat;
    }

    public Integer getProfileSrc() {
        return profileSrc;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public String getRecentTalk() {
        return recentTalk;
    }

    public Integer getBeforeTime() {
        return beforeTime;
    }

    public Integer getNumOfChat() {
        return numOfChat;
    }
}
