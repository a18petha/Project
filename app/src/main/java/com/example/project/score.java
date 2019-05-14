package com.example.project;

public class score {


    public class scorepoints {
        private String id;
        private String league;
        private String lagett;
        private String lagtvå;
        private int lagettpoints;
        private int lagtvåpoints;
        private String location;
        private String date;


        public scorepoints(String inId, String inLeague, String inLagett, String inLagtvå, int inLagettpoints,
                     int inlagtvåpoints, String inLocation, String inDate) {
            id = inId;
            league = inLeague;
            lagett = inLagett;
            lagtvå = inLagtvå;
            lagettpoints = inLagettpoints;
            lagtvåpoints = inlagtvåpoints;
            location = inLocation;
            date = inDate;
        }

        public scorepoints(String inId) {
            id = inId;
            league = "";
            lagett = "";
            lagtvå = "";
            lagettpoints =-1;
            lagtvåpoints =-1;
            location = "";
            date = "";
        }

        public String toString() {
            return id;
        }

        public String info() {
            String str = id;
            str += " league is ";
            str += league;
            str += " team one is ";
            str += lagett;
            str += "team two is ";
            str += lagtvå;
            str += Integer.toString(lagettpoints);
            str += "score ";
            str += Integer.toString(lagtvåpoints);
            str += "score ";
            str += "the loection is ";
            str += location;
            str += "date is ";
            str += date;
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

        public String getLocation() {
            return location;
        }

        public String getDate() {
            return date;
        }

    }

}
