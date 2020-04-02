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
import javafx.scene.control.Label;
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
    @FXML
    private Label toolSelectedLabel;
    @FXML
    private ListView<String> underObjectToolSelect = new ListView<>();

    private ObservableList<String> toolList = FXCollections.observableArrayList("Pointer","Objects","PlayerCharacters","Enemies","Cars","Backgrounds");
    private ObservableList<String> underObjectToolList = FXCollections.observableArrayList("Square","Circle","Triangle");



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

        playableCharacterSprite.setFocusTraversable(true);
        playableCharacterSprite.setImage(new Image(mario.getPhoto()));

        playableCharacterSprite.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                switch (keyEvent.getCode()){
                    case D:
                        playableCharacterSprite.setX(playableCharacterSprite.getX()+10);
                        keyEvent.consume();
                        break;
                    case A :
                        playableCharacterSprite.setX(playableCharacterSprite.getX()-10);
                        keyEvent.consume();
                        break;
                    case W :
                        playableCharacterSprite.setY(playableCharacterSprite.getY()-10);
                        keyEvent.consume();
                        break;
                    case S :
                        playableCharacterSprite.setY(playableCharacterSprite.getY()+10);
                        keyEvent.consume();
                        break;
                }

            }
        });


        toolSelect.setItems(toolList);

        toolSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue ) {
                toolSelectedLabel.setText(newValue);
                if(newValue == "Objects") {
                    underObjectToolSelect.setItems(underObjectToolList);
                }
                else {
                    underObjectToolSelect.setItems(null);
                }
            }

        });

    }


}
