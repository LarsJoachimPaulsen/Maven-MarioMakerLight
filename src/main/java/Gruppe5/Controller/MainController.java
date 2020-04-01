package Gruppe5.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    public Button btnTest;

    @FXML
    public TextField txtField;


    public void testAction(){

        txtField.setText("Vegard er homo");
        System.out.println("123");
    }



}
