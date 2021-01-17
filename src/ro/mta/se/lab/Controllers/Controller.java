package ro.mta.se.lab.Controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import ro.mta.se.lab.Utility.EffectsHandler;
import ro.mta.se.lab.WeatherAPI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;


public class Controller {
    //sa te uiti la fxml

    @FXML
    public ImageView exitButtonImage;
    @FXML
    public ImageView refreshButtonImage;
    @FXML
    public Label RegionSelectLabel;
    @FXML
    public AnchorPane parentContainer;
    @FXML
    public AnchorPane container;
    @FXML
    public Label celsiusGradLabel;
    @FXML
    public Label dateMonthLabel;
    @FXML
    public Label dateDayLabel;
    @FXML
    public Label statusLabel;
    @FXML
    public Label windSpeedLabel;
    @FXML
    public Label humidityLabel;
    @FXML
    public Label clearSkyLabel;
    @FXML
    public ImageView weatherStatusImage;

    private static WeatherAPI api;

    private selectorController ctrl;

    private String Country;
    private String City;

   // Controller(Parent scene){ this.scene = scene;}

    public void regionSelect_button(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL url =  new File("src/ro/mta/se/lab/Views/selector.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);

            root = loader.load();

            ctrl = loader.getController();

            api.loadListView(ctrl.countryList);


            Scene scene = RegionSelectLabel.getScene();

            root.translateXProperty().set(scene.getHeight());
            parentContainer.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.4), kv);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(eventl ->{
                parentContainer.getChildren().remove(container);
            });

            timeline.play();

            EffectsHandler.PlayPathTransition(ctrl.backButton, 0.4, -14, 1);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void close_button(javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);
    }

    public static Node findItemById(Parent root, @NotNull String ID)
    {
        Node n;
        if (ID.contains("#"))
        {
             n = root.lookup(ID);
            return n;
        }
        else {
            ID = '#' + ID;
            n = root.lookup(ID);
            return n;
        }
    }

    public static void passAPI(WeatherAPI API)
    {
        api = API;
    }

    public void passLocation (String Country, String City)
    {
        this.Country = Country;
        this.City = City;

        api.fetchAPI_JSON_Data(this.Country,this.City);
         Map<String,Object> mainMap = api.getMainMap();
         Map<String,Object> windMap = api.getWindMap();
         Map<String,Object> weatherMap = api.getWeatherMap();
        //Weather[] weatherArray = api.getWeatherArray();
        Map<String,Object> cloudsMap = api.getCloudsMap();

         double cloudiness = Double.parseDouble(cloudsMap.get("all").toString());
         double sunshine = 100-cloudiness;
         String sun = sunshine + "";

         String windSpeed = windMap.get("speed").toString();

         String humidity = mainMap.get("humidity").toString();

         String temperature = mainMap.get("temp").toString();

         String weatherStatus = new String();
        weatherStatus = weatherMap.get(" description").toString();


         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEE dd MMMMM yyyy", new Locale("en", "RO"));
        String date = simpleDateFormat.format(new Date());

         this.loadInterface(sun, windSpeed,humidity,temperature,weatherStatus,date);

    }

    private void loadInterface(String sun, String windSpeed, String humidity, String temperature, String weatherStatus, String date)
    {
        System.out.println(sun + " " + windSpeed + " " +humidity + " " +temperature+ " " + weatherStatus + " " + date);
        String[] day_and_month = date.split(" ");

        this.dateDayLabel.setText(day_and_month[2]);
        this.dateMonthLabel.setText(day_and_month[1]);

        this.clearSkyLabel.setText(sun+"%");

        windSpeed += " m/s";
        this.windSpeedLabel.setText(windSpeed);

        this.humidityLabel.setText(humidity);

        String[] intTemp = temperature.split("\\.");
        this.celsiusGradLabel.setText(intTemp[0]);

        this.RegionSelectLabel.setText(this.City+", "+this.Country);

        this.statusLabel.setText(weatherStatus);


        File f = null;
        if (weatherStatus.contains("clouds"))
        {
            if (weatherStatus.contains("few"))
            {
                f = new File("./src/ro/mta/se/lab/image/few_clouds.png");
                Image i = new Image(f.toURI().toString());
                this.weatherStatusImage.setImage(i);
            }

            if (weatherStatus.contains("scattered"))
            {
                f = new File("./src/ro/mta/se/lab/image/scattered_clouds.png");
                Image i = new Image(f.toURI().toString());
                this.weatherStatusImage.setImage(i);
            }
        }

        if (weatherStatus.contains("clear"))
        {
            f = new File("./src/ro/mta/se/lab/image/clear_sky.png");
            Image i = new Image(f.toURI().toString());
            this.weatherStatusImage.setImage(i);
        }

        if (weatherStatus.contains("snow"))
        {
            f = new File("./src/ro/mta/se/lab/image/Snow.png");
            Image i = new Image(f.toURI().toString());
            this.weatherStatusImage.setImage(i);
        }

        if (weatherStatus.contains("thunderstorm"))
        {
            f = new File("./src/ro/mta/se/lab/image/thunderstorm.png");
            Image i = new Image(f.toURI().toString());
            this.weatherStatusImage.setImage(i);
        }

        if (weatherStatus.contains("rain"))
        {
            f = new File("./src/ro/mta/se/lab/image/rain.png");
            Image i = new Image(f.toURI().toString());
            this.weatherStatusImage.setImage(i);
        }

        if (weatherStatus.contains("mist"))
        {
            f = new File("./src/ro/mta/se/lab/image/Mist.png");
            Image i = new Image(f.toURI().toString());
            this.weatherStatusImage.setImage(i);
        }

    }


}
