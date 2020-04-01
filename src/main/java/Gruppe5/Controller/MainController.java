package Gruppe5.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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



}
