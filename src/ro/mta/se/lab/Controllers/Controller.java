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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import ro.mta.se.lab.EffectsHandler;
import ro.mta.se.lab.Controllers.selectorController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//import javax.swing.text.html.ImageView;


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

    private selectorController ctrl;

   // Controller(Parent scene){ this.scene = scene;}

    public void regionSelect_button(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL url =  new File("src/ro/mta/se/lab/Views/selector.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);

            root = loader.load();

            ctrl = loader.getController();


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




}
