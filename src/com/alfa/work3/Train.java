package com.alfa.work3;

import com.alfa.work1.DaysOfWeek;

public class Train {
    private int number;
    private String stationDispatch;
    private String stationArrival;
    private String timeDispatch;
    private String timeArrival;
    private DaysOfWeek[] days;

    public Train(int number, String stationDispatch, String stationArrival, String timeDispatch, String timeArrival, DaysOfWeek[] days) {
        this.number = number;
        this.stationDispatch = stationDispatch;
        this.stationArrival = stationArrival;
        this.timeDispatch = timeDispatch;
        this.timeArrival = timeArrival;
        this.days = days;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStationDispatch() {
        return stationDispatch;
    }

    public void setStationDispatch(String stationDispatch) {
        this.stationDispatch = stationDispatch;
    }

    public String getStationArrival() {
        return stationArrival;
    }

    public void setStationArrival(String stationArrival) {
        this.stationArrival = stationArrival;
    }

    public String getTimeDispatch() {
        return timeDispatch;
    }

    public void setTimeDispatch(String timeDispatch) {
        this.timeDispatch = timeDispatch;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public DaysOfWeek[] getDays() {
        return days;
    }

    public void setDays(DaysOfWeek[] days) {
        this.days = days;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Train number " + number + " dispatch from " + stationDispatch + " at " + timeDispatch + " arrival to " + stationArrival + " at " + timeArrival + " leaves on the following day(s): ");
        int i = 0;
        int length = days.length - 1;
        for (DaysOfWeek day : days) {
            if (i < length) {
                info.append(day.toString()).append(", ");
                i++;
            } else {
                info.append(day.toString());
            }
        }
        return info.toString();
    }

    public boolean inDay(String day) {
        for (DaysOfWeek d : days) {
            if (d.toString().equalsIgnoreCase(day)) return true;
        }
        return false;
    }
}
