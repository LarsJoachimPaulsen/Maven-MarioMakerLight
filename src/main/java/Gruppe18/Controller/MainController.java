package Gruppe18.Controller;

import Gruppe18.Data.PlayerCharacter;
import Gruppe18.Data.PlayerCharacterBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MainController implements EventHandler<KeyEvent> {

    @FXML
    public Button btnTest;

    @FXML
    public TextField txtField;

    @FXML
    public ImageView playableCharacterSprite;

    @FXML
    private ListView<String> toolSelect = new ListView<>();

    private ObservableList<String> toolList = FXCollections.observableArrayList("Pointer", "Objects","PlayerCharacters","Enemies","Cars","Backgrounds");

    //@FXML
    //private ListView<ActionEvent> underToolSelect = new ListView<>();


    public void testAction(){

        txtField.setText("Vegard er homo");
        System.out.println("123");
    }

    @Override
    public void handle(KeyEvent keyEvent){

    }




    public void initialize() {
        PlayerCharacterBuilder m = new PlayerCharacterBuilder();

        PlayerCharacter mario = m.createPlayerCharacter();
        playableCharacterSprite.setImage(new Image(mario.getPhoto()));

        playableCharacterSprite.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               playableCharacterSprite.setX(playableCharacterSprite.getX()+10);
            }
        });

        /*
        toolSelect.getItems().add("Pointer");
        toolSelect.getItems().add("Objects");
        toolSelect.getItems().add("PlayerCharacters");
        toolSelect.getItems().add("Enemies");
        toolSelect.getItems().add("Cars");
        toolSelect.getItems().add("Backgrounds");
        */
        toolSelect.setItems(toolList);

        toolSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue ) {
                System.out.println("Selected item: " + newValue);
            }
        });

    }


}
