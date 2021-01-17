package ro.mta.se.lab.DataModels;

public class City {
    public String ID;
    public String cityName;
    public double lat;
    public double lon;
    public String countryCode;

    public City(String ID, String cityName, String lat, String lon, String countryCode) {
        this.ID = ID;
        this.cityName = cityName;
        this.lat = Double.parseDouble(lat);
        this.lon = Double.parseDouble(lon);
        this.countryCode = countryCode;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode()
    {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public double getLat()
    {
        return this.lat;
    }

    public void setLat(double lat)
    {
        this.lat=lat;
    }

    public double getLon()
    {
        return this.lon;
    }

    public void setLon(double lon)
    {
        this.lon = lon;
    }

    public String toString()
    {
        return new String(ID + " " + cityName + " " + lat + " " + lon + " " + countryCode);
    }

}
