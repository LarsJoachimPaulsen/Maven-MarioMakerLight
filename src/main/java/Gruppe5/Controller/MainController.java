package Gruppe5.Controller;

import Gruppe5.Data.PlayerCharacter;
import Gruppe5.Data.PlayerCharacterBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    public Button btnTest;

    @FXML
    public TextField txtField;

    @FXML
    public ImageView playableCharacterSprite;


    public void testAction(){

        txtField.setText("Vegard er homo");
        System.out.println("123");
    }





    public void initialize() {
        PlayerCharacterBuilder m = new PlayerCharacterBuilder();

        PlayerCharacter mario = m.createPlayerCharacter();
       playableCharacterSprite.setImage(new Image(mario.getPhoto()));
    }


}
