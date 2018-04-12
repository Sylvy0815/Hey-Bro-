package com.heybro.pnuite;

/**
 * Created by hjune08 on 2017-12-11.
 */

public class Team {
    String teamIcon;
    String teamName;
    String teamLevel;
    String teamLocation;

    public Team(String teamIcon, String teamName, String teamLevel, String teamLocation) {
        this.teamIcon = teamIcon;
        this.teamName = teamName;
        this.teamLevel = teamLevel;
        this.teamLocation = teamLocation;
    }

    public String getTeamIcon() {
        return teamIcon;
    }

    public void setTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLevel() {
        return teamLevel;
    }

    public void setTeamLevel(String teamLevel) {
        this.teamLevel = teamLevel;
    }

    public String getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(String teamLocation) {
        this.teamLocation = teamLocation;
    }
}
