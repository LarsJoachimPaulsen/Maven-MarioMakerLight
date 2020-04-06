package Gruppe18.Controller;

import Gruppe18.Data.*;
import Gruppe18.FileHandeling.Writer_Reader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Window;

public class MainController implements EventHandler<KeyEvent> {

    @FXML
    public Button btnTest;
    @FXML
    private Button btnConfirm;
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
    @FXML
    private Label txtPoints;
    @FXML
    private Button btnExitGame;

    private int characterMovementSpeed = 10;

    Writer_Reader reader = new Writer_Reader();
    Writer_Reader reader2 = new Writer_Reader();

    private ObservableList<String> toolList = FXCollections.observableArrayList("Pointer","Objects","PlayerCharacters","Enemies","Cars","Backgrounds");
    private ObservableList<String> underObjectToolList = FXCollections.observableArrayList("Square","Circle","Triangle");
    private ObservableList<PlayerCharacter> playerCharacters = FXCollections.observableArrayList(reader.getPlayableCharacters());
    private ObservableList<String> playerCharacterList = FXCollections.observableArrayList();
   // private ObservableList<Enemy> enemies = FXCollections.observableArrayList(reader.getEnemyCharacters());
   // private ObservableList<String> enemyList = FXCollections.observableArrayList();

    //private ArrayList<Enemy> enemies = reader2.getEnemyCharacters();
    //private ArrayList<Car> cars = reader.getCarCharacters();

    @Override
    public void handle(KeyEvent keyEvent){

    }

    public void confirm(){
      btnConfirm.setVisible(false);
      btnExitGame.setVisible(true);
      toolSelect.setVisible(false);
      toolSelectedLabel.setVisible(false);
      underObjectToolSelect.setVisible(false);
      txtPoints.setVisible(true);
      txtPoints.setText("");
      playableCharacterSprite.requestFocus();
      enableWalking();

    }

    private void enableWalking() {
        playableCharacterSprite.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Scene scene = playableCharacterSprite.getScene();
                switch (keyEvent.getCode()) {
                    case D:
                        if(playableCharacterSprite.getX() > scene.getWidth()){
                            playableCharacterSprite.setX(0);
                        }
                        else {
                        playableCharacterSprite.setX(playableCharacterSprite.getX() + characterMovementSpeed);
                        }
                        keyEvent.consume();
                        break;
                    case A:
                        if (playableCharacterSprite.getX() < 0){
                            playableCharacterSprite.setX(scene.getWidth());
                        }
                        else {
                            playableCharacterSprite.setX(playableCharacterSprite.getX() - characterMovementSpeed);
                        }
                        keyEvent.consume();
                        break;
                    case W:
                        if (playableCharacterSprite.getY() < -(toolSelect.getHeight())){
                            playableCharacterSprite.setY(scene.getHeight() - toolSelect.getHeight());
                        }
                        else {
                            playableCharacterSprite.setY(playableCharacterSprite.getY() - characterMovementSpeed);
                        }

                        keyEvent.consume();
                        break;
                    case S:
                        if (playableCharacterSprite.getY() > scene.getHeight() - toolSelect.getHeight()){
                            playableCharacterSprite.setY(-(toolSelect.getHeight()));
                        }
                        else {
                        playableCharacterSprite.setY(playableCharacterSprite.getY() + characterMovementSpeed);
                        }
                        keyEvent.consume();
                        break;
                }

            }
        });

    }

    public void exitGame(){
        btnConfirm.setVisible(true);
        btnExitGame.setVisible(false);
        toolSelect.setVisible(true);
        toolSelectedLabel.setVisible(true);
        underObjectToolSelect.setVisible(true);
        txtPoints.setVisible(false);
        removeWalking();
    }

    private void removeWalking() {

    }

    public void initialize() {

        System.out.println( Window.getWindows().size());



        playableCharacterSprite.setFocusTraversable(true);
        playableCharacterSprite.setImage(new Image("/Pictures/PlayableCharacters/aleksander.png"));
        playableCharacterSprite.setFitHeight(playerCharacters.get(0).getSize()*10);
        characterMovementSpeed = playerCharacters.get(0).getMovementSpeed();


        toolSelect.setItems(toolList);
        for(int i = 0; i < playerCharacters.size(); i++) {
            playerCharacterList.add(playerCharacters.get(i).getName());
        }
        /*
        for(int i = 0; i < enemies.size(); i++) {
            enemyList.add(enemies.get(i).getName());
        }

         */

        toolSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue ) {
                toolSelectedLabel.setText(newValue);
                if(newValue.equals("Objects")) {
                    underObjectToolSelect.setItems(underObjectToolList);
                }
                else if(newValue.equals("PlayerCharacters")){
                    underObjectToolSelect.setItems(playerCharacterList);
                }
                /*
                else if(newValue.equals("Enemies")) {
                    underObjectToolSelect.setItems(enemyList);
                }

                 */
                else {
                    underObjectToolSelect.setItems(null);
                }
            }

        });

    }




}
