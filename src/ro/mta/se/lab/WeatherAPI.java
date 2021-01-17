package ro.mta.se.lab;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.scene.control.ListView;
import ro.mta.se.lab.DataModels.City;
import ro.mta.se.lab.DataModels.Weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class WeatherAPI
{
    private String API_KEY = "8a8d2a0298740054d21aca60f859dd45";
    private File locationsFile;
    private String urlString = "https://api.openweathermap.org/data/2.5/weather?q=";
    private Map<String, Object> map;
    private Map<City, String> inputGeoData;
    private Map<String, String> Countries;
    private  Map<String,Object> mainMap = null;
    private  Map<String,Object> windMap = null;
    private  Map<String,Object> weatherMap = null;
    private  Map<String,Object> cloudsMap = null;
    Weather[] wArray = null;

    private String LOCATION;

    private void mapCountryCodes(String cc)
    {
        switch (cc){
            case "RO":
                this.Countries.put(cc, "Romania");
                break;
            case "RU":
                this.Countries.put(cc, "Russia");
                break;
            case "IT":
                this.Countries.put(cc, "Italia");
                break;
            case "PL":
                this.Countries.put(cc, "Poland");
                break;
            case "HU":
                this.Countries.put(cc, "Hungary");
                break;
            case "IL":
                this.Countries.put(cc, "Israel");
                break;
            case "DE":
                this.Countries.put(cc, "Germany");
                break;
            case "MD":
                this.Countries.put(cc, "Republica Moldova");
                break;
            case "SE":
                this.Countries.put(cc, "Sweden");
                break;
            case "DK":
                this.Countries.put(cc, "Denmark");
                break;
        }
    }

    private Map<String, Object> jsonToMap(String str)
    {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }

    public WeatherAPI(){
            locationsFile =  new File("./src/ro/mta/se/lab/geolocationData.txt");
            if (!locationsFile.exists())
            {
                System.out.println("File does not exist!");
            }
    }

    public void initWeatherAPI()
    {
        this.inputGeoData = new HashMap<>();
        this.Countries = new HashMap<>();

        try {
            Scanner reader = new Scanner(this.locationsFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] cityData = data.split("\t");

                String cc = cityData[4];

                City city = new City(cityData[0], cityData[1], cityData[2], cityData[3], cityData[4]);
                this.inputGeoData.put(city, cityData[4]);



                if (this.Countries.isEmpty())
                {
                  mapCountryCodes(cc);
                }
                else {
                    if (!this.Countries.containsKey("cc"))
                    {
                        mapCountryCodes(cc);
                    }
                }



            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void loadListView(ListView UI)
    {
        Iterator iterator = this.Countries.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            UI.getItems().add(pair.getValue());
        }
    }

    public void loadListView(ListView UI, String countryCode)
    {
        Iterator iterator = this.inputGeoData.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
           // UI.getItems().add(pair.getValue());
            String val = (String) pair.getValue();

            if (val.equals(countryCode))
            {
                Object o =  pair.getKey();
                City c = (City) o;
                UI.getItems().add(c.cityName);
            }
        }
    }

    public Map<String,String> getCountriesMap()
    {
        return this.Countries;
    }

    public String getCountryCode(String countryName)
    {
        String CO;
        Iterator iterator = this.Countries.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            CO = (String) pair.getKey();

            if (this.Countries.get(CO).equals(countryName))
            {
                return CO;
            }
        }

        CO = null;
        return CO;

    }

    public void fetchAPI_JSON_Data(String country, String city)
    {

        urlString = "https://api.openweathermap.org/data/2.5/weather?q="; // reset string
        String location = city+","+country;
        this.urlString += location + "&appid=" + API_KEY + "&units=metric";
        try{
            StringBuilder result = new StringBuilder();
            URL uri = new URL(urlString);
            URLConnection conn = uri.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line=rd.readLine()) != null)
            {
                result.append(line);
            }

            rd.close();
            System.out.println(result);

            Map<String,Object> respMap = jsonToMap(result.toString());
             this.mainMap = jsonToMap(respMap.get("main").toString());
            System.out.println(respMap.get("main").toString());
             this.windMap = jsonToMap(respMap.get("wind").toString());
            System.out.println(respMap.get("wind").toString());
             this.cloudsMap = jsonToMap(respMap.get("clouds").toString());
            System.out.println(respMap.get("clouds").toString());
             this.weatherMap = new HashMap<>();

             String json = respMap.get("weather").toString();
             String res = json.substring(2,json.length()-2);
             String[] res2 = res.split(",");
             for (int i=0; i<res2.length; i++)
             {
                 String[] key_value = res2[i].split("=");

                 this.weatherMap.put(key_value[0], key_value[1]);
             }


             System.out.println(res);
            // this.weatherMap = jsonToMap(res);

            //this.weatherMap = jsonToMap(respMap.get("weather").toString());


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Map<String,Object> getMainMap()
    {
        return this.mainMap;
    }

    public Map<String,Object> getWindMap()
    {
        return this.windMap;
    }

    public Map<String,Object> getWeatherMap()
    {
        return this.weatherMap;
    }

    public Weather[] getWeatherArray()
    {
        return this.wArray;
    }

    public Map<String,Object> getCloudsMap()
    {
        return this.cloudsMap;
    }

    public void reset()
    {
        this.weatherMap.clear();
        this.cloudsMap.clear();
        this.mainMap.clear();
        this.windMap.clear();
    }

}
