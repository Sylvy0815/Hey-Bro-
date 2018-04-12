package com.heybro.pnuite;

/**
 * Created by hjune08 on 2017-12-06.
 */

public class User {
    String userID;
    String userPassword;
    String userName;
    String userAge;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public User(String userID, String userPassword, String userName, String userAge) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAge = userAge;
    }
}
