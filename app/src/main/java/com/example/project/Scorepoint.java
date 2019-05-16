package com.example.project;

public class Scorepoint {
    private String location;
    private String id;
    private String league;
    private String lagett;
    private String lagtvå;
    private String date;
    private int lagettpoints;
    private int lagtvåpoints;

    public Scorepoint (String inId, String inLeague, String inLagett, String inLagtvå, int inLagettpoints,
                  int inlagtvåpoints, String inLocation, String inDate) {
        location = inLocation;
        id = inId;
        league = inLeague;
        lagett = inLagett;
        lagtvå = inLagtvå;
        lagettpoints = inLagettpoints;
        lagtvåpoints = inlagtvåpoints;
        date = inDate;
    }

    public Scorepoint(String inLocation) {
        location = inLocation;
        id = "";
        league = "";
        lagett = "";
        lagtvå = "";
        lagettpoints =-1;
        lagtvåpoints =-1;
        date = "";
    }

    public String toString() {
        return location;
    }

    public String info() {
        String str = location;
        str += "location is";
        str += id;
        str += "id is";
        str += league;
        str += "league is";
        str += lagett;
        str += "lagett is";
        str += lagtvå;
        str += "lagtvå is";
        str += date;
        str += "date is";
        str += Integer.toString(lagettpoints);
        str += "score one is";
        str += Integer.toString(lagtvåpoints);
        str += "score two is";
        return str;
    }


    public String getId() {
        return id;
    }

    public String getLeague() {
        return league;
    }

    public String getLagett() {
        return lagett;
    }

    public String getLagtvå() {
        return lagtvå;
    }

    public void setPointOne(int newPointOne) {
        lagettpoints = newPointOne;
    }
    public void setPointTwo(int newPointTwo) {
        lagtvåpoints = newPointTwo;
    }

    public int getLagettpoints(){
        return lagettpoints;
    }

    public int getLagtvåpoints(){
        return lagtvåpoints;
    }
    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

}
