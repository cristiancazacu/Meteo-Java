package ro.mta.se.lab.Controllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import ro.mta.se.lab.EffectsHandler;

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

    private Controller ctrl;

    public void back_button(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL url =  new File("src/ro/mta/se/lab/Views/mainWindow.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);

            root = loader.load();

            ctrl = loader.getController();


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

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
