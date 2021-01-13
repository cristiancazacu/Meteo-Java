package ro.mta.se.lab;

import animatefx.animation.*;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import ro.mta.se.lab.image.EffectsHandler;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml")); //save instance of Controller
        Parent root;


        try {
            root = loader.load();
        } catch (IOException ex)
        {
            return;
        }

        Controller ctrl = (Controller) loader.getController();

        primaryStage.setTitle("Meteo");     // Titlu App
        primaryStage.setScene(new Scene(root, 400, 380));   // inaltime: 400, latime: 380
        primaryStage.initStyle(StageStyle.TRANSPARENT);         // dispar colturi albe
        primaryStage.getScene().setFill(Color.TRANSPARENT);     // dispar colturi albe
        primaryStage.show();


        EffectsHandler.PlayFadeInEffect(root);
        EffectsHandler.PlayPulseEffect(root);
        EffectsHandler.PlayImageRotationTranslate(ctrl.refreshButtonImage, 0.5,0,185,true,1);
        EffectsHandler.PlayImageButtonSelected(ctrl.exitButtonImage);


        //refreshButtonImage = (ImageView) root.lookup("#refreshButtonImage");
        //Node uiobject = refreshButtonImage;
        //Node element = root;


    }


    public static void main(String[] args) {
        launch(args);
    }
}
