package com.example.project;

import android.location.Location;

public class Scorepoint {
    private String location;
    private String ID;
    private String league;
    private String lagett;
    private String lagtvo;
    private String date;
    private String imageone;
    private String imagetwo;
    private int lagettpoints;
    private int lagtvopoints;


    public Scorepoint(String inLocation, String inId, String inLeague, String inLagett, String inLagtvo, String inDate,
                      String inImageone, String inImagetwo,  int inLagettpoints, int inLagtvopoints) {
        location = inLocation;
        ID = inId;
        league = inLeague;
        lagett = inLagett;
        lagtvo = inLagtvo;
        date = inDate;
        imageone = inImageone;
        imagetwo = inImagetwo;
        lagettpoints = inLagettpoints;
        lagtvopoints = inLagtvopoints;
    }

    public Scorepoint(String inLocation) {
        location = inLocation;
        ID = "";
        league = "";
        lagett = "";
        lagtvo = "";
        date = "";
        imageone = "";
        imagetwo = "";
        lagettpoints = -1;
        lagtvopoints = -1;
    }

    public String toString() {
        return location;
    }

    public String info() {
        String str = location;
        str += " games id";
        str += ID;
        str += " games league";
        str += league;
        str += " lagett plays";
        str += lagett;
        str += " lagtvå plays";
        str += lagtvo;
        str += " games date";
        str += date;
        str += "imageone";
        str += imageone;
        str += "imagetwo";
        str += imagetwo;
        str += " points of team one";
        str += Integer.toString(lagettpoints);
        str += "m.";
        str += " points of team two";
        str += Integer.toString(lagtvopoints);
        str += "m.";
        return str;
    }

    public void setScoreOne(int newscore) {
        lagettpoints = newscore;
    }

    public void setScoretwo(int newscore) {
        lagettpoints = newscore;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return ID;
    }

    public String getLeague() {
        return league;
    }
    public String getLagett() {
        return lagett;
    }
    public String getLagtvå() {
        return lagtvo;
    }
    public String getDate() {
        return date;
    }
    public String getImageone() {
        return imageone;
    }
    public String getImagetwo() { return imagetwo; }

    public int getLagettpoints() {
        return lagettpoints;
    }
    public int getLagtvåpoints() {
        return lagtvopoints;
    }

}
