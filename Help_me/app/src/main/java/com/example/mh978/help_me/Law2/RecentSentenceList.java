package com.example.mh978.help_me.Law2;

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
        eventNo = eventNo.replaceAll(System.getProperty("line.separator"), "");
        //eventNo.replace("\n", " ");
        return eventNo;
    }

    public void setEventNo(String eventNo) {
        this.eventNo = eventNo;
    }

    public String getEventNm() {
        eventNm = eventNm.replaceAll(System.getProperty("line.separator"), "");
        //eventNm.replace("\n", " ");
        return eventNm;
    }

    public void setEventNm(String eventNm) {
        this.eventNm = eventNm;
    }

    public String getClassNm() {
        classNm = classNm.replaceAll(System.getProperty("line.separator"), "");
        //classNm.replace("\n", " ");
        return classNm;
    }

    public void setClassNm(String classNm) {
        this.classNm = classNm;
    }
}
