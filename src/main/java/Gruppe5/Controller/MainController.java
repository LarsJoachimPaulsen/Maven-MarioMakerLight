package Gruppe5.Controller;

import Gruppe5.Model.PlayerCharacter;
import Gruppe5.Model.PlayerCharacterBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;

public class MainController {

    @FXML
    public Button btnTest;

    @FXML
    public TextField txtField;

    @FXML
    public ImageView playableCharacterSprite;

    @FXML
    private ListView<ActionEvent> toolSelect = new ListView<>();

    private ObservableList<ActionEvent> toolList = FXCollections.observableArrayList();

    //@FXML
    //private ListView<ActionEvent> underToolSelect = new ListView<>();




    public void initialize() {
        PlayerCharacterBuilder m = new PlayerCharacterBuilder();

        PlayerCharacter mario = m.createPlayerCharacter();
        playableCharacterSprite.setImage(new Image(mario.getPhoto()));

        toolSelect.setItems(toolList);


    }

    public void testAction(){

        txtField.setText("Vegard er homo");
        System.out.println("123");
    }


}
