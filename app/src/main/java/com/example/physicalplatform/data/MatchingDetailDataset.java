package com.example.physicalplatform.data;

public class MatchingDetailDataset {
    private String listTitle;               // 신청한 강의 제목
    private String trainer;                 // 강사 이름
    private String summary;                 // 간단 설명
    private String period;                  // 강의 시간
    private Double rating;                  // 강의 평점
    private String introductionContents;    // 수업소개 내용
    private String curriculumContents;      // 커리큘럼 내용
    private String classPlanSummary;        // 수업일정 내용

    public MatchingDetailDataset(String listTitle, String trainer, String summary, String period, Double rating, String introductionContents, String curriculumContents, String classPlanSummary) {
        this.listTitle = listTitle;
        this.trainer = trainer;
        this.summary = summary;
        this.period = period;
        this.rating = rating;
        this.introductionContents = introductionContents;
        this.curriculumContents = curriculumContents;
        this.classPlanSummary = classPlanSummary;
    }

    public String getListTitle() {
        return listTitle;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getSummary() {
        return summary;
    }

    public String getPeriod() {
        return period;
    }

    public Double getRating() {
        return rating;
    }

    public String getIntroductionContents() {
        return introductionContents;
    }

    public String getCurriculumContents() {
        return curriculumContents;
    }

    public String getClassPlanSummary() {
        return classPlanSummary;
    }
}
