package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ro.mta.se.lab.Controllers.Controller;
import ro.mta.se.lab.Controllers.selectorController;
import ro.mta.se.lab.Utility.EffectsHandler;


import java.io.IOException;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/mainWindow.fxml")); //save instance of Controller
        Parent root;

        WeatherAPI api = new WeatherAPI();
        api.initWeatherAPI();

        Controller.passAPI(api);
        selectorController.passAPI(api);


        try {
            root = loader.load();
        } catch (IOException ex)
        {
            return;
        }

        Controller ctrl = (Controller) loader.getController();

        primaryStage.setTitle("Meteo");     // Titlu App
        primaryStage.setScene(new Scene(root, 399, 379));   // latime: 399, inaltime: 379
        primaryStage.initStyle(StageStyle.TRANSPARENT);         // dispar colturi albe
        primaryStage.getScene().setFill(Color.TRANSPARENT);     // dispar colturi albe
        primaryStage.show();


        EffectsHandler.PlayFadeInEffect(root);
        EffectsHandler.PlayPulseEffect(root);
        EffectsHandler.PlayImageRotationTranslate(ctrl.refreshButtonImage, 0.5,0,185,true,1);
        EffectsHandler.PlayImageButtonSelected(ctrl.exitButtonImage);



    }


    public static void main(String[] args) {
        launch(args);
    }
}
