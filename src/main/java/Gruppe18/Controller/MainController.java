package Gruppe18.Controller;

import Gruppe18.Data.PlayerCharacter;
import Gruppe18.Data.PlayerCharacterBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
