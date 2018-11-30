package com.example.youngshiny.recentsentence_fix;

public class RecentSentenceList
{
    private String eventNo, eventNm, classNm;

    public RecentSentenceList (String eventNo, String eventNm, String classNm)
    {
        this.eventNo = eventNo;
        this.eventNm = eventNm;
        this.classNm = classNm;
    }

    public String getEventNo() {
        return eventNo;
    }

    public void setEventNo(String eventNo) {
        this.eventNo = eventNo;
    }

    public String getEventNm() {
        return eventNm;
    }

    public void setEventNm(String eventNm) {
        this.eventNm = eventNm;
    }

    public String getClassNm() {
        return classNm;
    }

    public void setClassNm(String classNm) {
        this.classNm = classNm;
    }
}
