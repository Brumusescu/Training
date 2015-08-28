package com.endava.TVseries;

/**
 * Created by dbrumusescu on 8/27/2015.
 */
public class TVSeries {
    private String name;
    private String day;
    private String hour;
    private String type;

    public TVSeries(String name, String day, String hour, String information) {
        this.name = name;
        this.day = day;
        this.hour = hour;
        this.type = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ("Name: " + this.name + "\n" +
                "Day: " + this.day + "\n" +
                "Hour: " + this.hour + "\n" +
                "Information: " + this.type);
    }
}
