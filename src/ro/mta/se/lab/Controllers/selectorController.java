package ro.mta.se.lab.Controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import ro.mta.se.lab.Utility.EffectsHandler;
import ro.mta.se.lab.WeatherAPI;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class selectorController {
    @FXML
    public ImageView backButton;
    @FXML
    public AnchorPane container;
    @FXML
    public AnchorPane parentContainer;
    @FXML
    public ListView countryList;
    @FXML
    public ListView cityList;

    public String Country;
    public String City;

    private Controller ctrl;
    private static WeatherAPI api;

    public void back_button(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL url =  new File("src/ro/mta/se/lab/Views/mainWindow.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);

            root = loader.load();

            ctrl = loader.getController();
            ctrl.passLocation(this.Country, this.City);


            Scene scene = backButton.getScene();

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

            EffectsHandler.PlayImageRotationTranslate(ctrl.refreshButtonImage, 0.5,0,185,true,1);
            EffectsHandler.PlayImageButtonSelected(ctrl.exitButtonImage);

            api.reset();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void passAPI(WeatherAPI API)
    {
        api = API;
    }

    public void countryHandleMouseClick(MouseEvent mouseEvent) {

        Country = this.countryList.getSelectionModel().getSelectedItem().toString();
        cityList.getItems().clear();
        String  country = "" + this.countryList.getSelectionModel().getSelectedItem();
        String countryCode = api.getCountryCode(country);

        api.loadListView(this.cityList, countryCode);
    }

    public void cityHandleMouseClick(MouseEvent mouseEvent) {
        this.City = this.cityList.getSelectionModel().getSelectedItem().toString();
    }
}
