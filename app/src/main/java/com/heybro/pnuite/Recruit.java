package com.heybro.pnuite;

/**
 * Created by hjune08 on 2017-12-07.
 */

public class Recruit {
    int recruitNum;
    String recruitID;
    String recruitName;
    String recruitPosition;
    String recruitLocation;
    String recruitDate;

    public Recruit(int recruitNum, String recruitID, String recruitName, String recruitPosition, String recruitLocation, String recruitDate) {
        this.recruitNum = recruitNum;
        this.recruitID = recruitID;
        this.recruitName = recruitName;
        this.recruitPosition = recruitPosition;
        this.recruitLocation = recruitLocation;
        this.recruitDate = recruitDate;
    }

    public int getRecruitNum() {
        return recruitNum;
    }

    public void setRecruitNum(int recruitNum) {
        this.recruitNum = recruitNum;
    }

    public String getRecruitID() {
        return recruitID;
    }

    public void setRecruitID(String recruitID) {
        this.recruitID = recruitID;
    }

    public String getRecruitName() {
        return recruitName;
    }

    public void setRecruitName(String recruitName) {
        this.recruitName = recruitName;
    }

    public String getRecruitPosition() {
        return recruitPosition;
    }

    public void setRecruitPosition(String recruitPosition) {
        this.recruitPosition = recruitPosition;
    }

    public String getRecruitLocation() {
        return recruitLocation;
    }

    public void setRecruitLocation(String recruitLocation) {
        this.recruitLocation = recruitLocation;
    }

    public String getRecruitDate() {
        return recruitDate;
    }

    public void setRecruitDate(String recruitDate) {
        this.recruitDate = recruitDate;
    }

}
