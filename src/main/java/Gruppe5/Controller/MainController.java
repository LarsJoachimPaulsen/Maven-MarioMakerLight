package Gruppe5.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    public Button btnTest;

    @FXML
    public TextField txtField;

    @FXML
    public ImageView characterImage;


    public void testAction(){

        txtField.setText("Vegard er homo");
        System.out.println("123");
    }


    public void initialize(URL location, ResourceBundle resources) {
        characterImage.setImage(new Image("src/main/resources/Pictures/enemy.png"));
    }


}
