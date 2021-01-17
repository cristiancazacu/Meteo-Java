package ro.mta.se.lab.DataModels;

public class Weather {
    public String id;
    public String main;
    public String description;
    public String icon;

    public Weather(String id, String main, String description, String icon)
    {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public String toString()
    {
        return id+" "+main+" "+description+" "+icon;
    }

}
