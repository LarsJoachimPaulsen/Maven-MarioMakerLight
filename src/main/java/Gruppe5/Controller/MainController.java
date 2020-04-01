package Gruppe5.Controller;

import Gruppe5.Data.PlayerCharacter;
import Gruppe5.Data.PlayerCharacterBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MainController {

    @FXML
    public Button btnTest;

    @FXML
    public TextField txtField;

    @FXML
    public ImageView playableCharacterSprite;

    @FXML
    private ListView<String> toolSelect = new ListView<>();

    @FXML
    private ListView<String> underToolSelect = new ListView<>();

    public void testAction(){

        txtField.setText("Vegard er homo");
        System.out.println("123");
    }




    PlayerCharacterBuilder m = new PlayerCharacterBuilder();

    PlayerCharacter mario = m.createPlayerCharacter();



    public void initialize() {
        playableCharacterSprite.setImage(mario.getPhoto());
    }


}
