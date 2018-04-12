package com.heybro.pnuite;

/**
 * Created by hjune08 on 2017-12-07.
 */

public class Enter {
    int enterNum;
    String enterID;
    String enterName;
    String enterPosition;
    String enterLocation;
    String enterDate;

    public Enter(int enterNum, String enterID, String enterName, String enterPosition, String enterLocation, String enterDate) {
        this.enterNum = enterNum;
        this.enterID = enterID;
        this.enterName = enterName;
        this.enterPosition = enterPosition;
        this.enterLocation = enterLocation;
        this.enterDate = enterDate;
    }

    public int getEnterNum() {
        return enterNum;
    }

    public void setEnterNum(int enterNum) {
        this.enterNum = enterNum;
    }

    public String getEnterID() {
        return enterID;
    }

    public void setEnterID(String enterID) {
        this.enterID = enterID;
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName;
    }

    public String getEnterPosition() {
        return enterPosition;
    }

    public void setEnterPosition(String enterPosition) {
        this.enterPosition = enterPosition;
    }

    public String getEnterLocation() {
        return enterLocation;
    }

    public void setEnterLocation(String enterLocation) {
        this.enterLocation = enterLocation;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }
}
