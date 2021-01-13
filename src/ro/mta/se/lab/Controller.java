package ro.mta.se.lab;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;
//import javax.swing.text.html.ImageView;
import java.awt.event.MouseEvent;



public class Controller {
    @FXML
    public ImageView exitButtonImage;
    @FXML
    public ImageView refreshButtonImage;

   // Controller(Parent scene){ this.scene = scene;}


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
