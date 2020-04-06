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
    private ImageView enemySprite;
    @FXML
    private ImageView carSprite;
    @FXML
    private ListView<String> toolSelect = new ListView<>();
    @FXML
    private Label toolSelectedLabel;
    @FXML
    private ListView<String> underObjectToolSelect = new ListView<>();
    @FXML
    private ListView<Image> underCharacterToolSelect = new ListView<>();
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
    private ObservableList<Image> playerCharacterList = FXCollections.observableArrayList();
    // private ObservableList<Enemy> enemies = FXCollections.observableArrayList(reader.getEnemyCharacters());
    //private ObservableList<String> playerCharacterList = FXCollections.observableArrayList();
    private ObservableList<Enemy> enemyCharacters = FXCollections.observableArrayList(reader2.getEnemyCharacters());
    private ObservableList<Car> carCharacters = FXCollections.observableArrayList(reader.getCarCharacters());
    // private ObservableList<String> enemyList = FXCollections.observableArrayList();


    //private ArrayList<Enemy> enemies = reader2.getEnemyCharacters();
    //private ArrayList<Car> cars = reader.getCarCharacters();

    private double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private double screenHeigth =  Screen.getPrimary().getBounds().getHeight();

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
                            playableCharacterSprite.setY(scene.getHeight());
                        }
                        else {
                            playableCharacterSprite.setY(playableCharacterSprite.getY() - characterMovementSpeed);
                        }

                        keyEvent.consume();
                        break;
                    case S:
                        if (playableCharacterSprite.getY() > scene.getHeight()){
                            playableCharacterSprite.setY(0);
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
        //testkode - karakteren på skjermen
        playableCharacterSprite.setFocusTraversable(true);

        playableCharacterSprite.setImage(new Image(playerCharacters.get(0).getPhoto()));
       // playableCharacterSprite.setImage(new Image("/Pictures/PlayableCharacters/aleksander.png"));
        playableCharacterSprite.setFitHeight(playerCharacters.get(0).getSize()*10);
        characterMovementSpeed = playerCharacters.get(0).getMovementSpeed();

        enemySprite.setImage(new Image(enemyCharacters.get(0).getPhoto()));
        enemySprite.setFitHeight(enemyCharacters.get(0).getSize()*10);

        carSprite.setImage(new Image(carCharacters.get(0).getPhoto()));
        carSprite.setFitHeight(carCharacters.get(0).getHeight()*10);

        setUpButtons();


        toolSelect.setItems(toolList);
        for(int i = 0; i < playerCharacters.size(); i++) {
            playerCharacterList.add(new Image(playerCharacters.get(i).getPhoto()));
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
                    hideToolbars();
                    underObjectToolSelect.setVisible(true);
                    underObjectToolSelect.setItems(underObjectToolList);
                }
                else if(newValue.equals("PlayerCharacters")){
                    hideToolbars();
                    //addPlayerCharactersToToolbar();
                    underCharacterToolSelect.setItems(playerCharacterList);
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

    private void hideToolbars() {
        underObjectToolSelect.setVisible(false);

    }

    private void addPlayerCharactersToToolbar() {

        for (int i = 0; i<playerCharacters.size(); i++){
           // String name = String.valueOf(i);
            ImageView name  = new ImageView();
            name.setImage(new Image(playerCharacters.get(i).getPhoto()));
           // name.setX((screenWidth/2)/(double)playerCharacters.size());
            name.setLayoutY(screenHeigth/2);
            name.setLayoutX(screenWidth/2);
           // name.setLayoutX(screenWidth*.05 + screenWidth/(double)playerCharacters.size());
        }

    }

    private void setUpButtons() {
            btnConfirm.setLayoutY(screenHeigth/2);
            btnConfirm.setLayoutX(screenWidth/2);

            btnExitGame.setLayoutY(30);
            btnExitGame.setLayoutX(screenWidth-50);

            toolSelect.setMinHeight(screenHeigth);
            toolSelect.setMinWidth(screenWidth*.05);
            toolSelectedLabel.setLayoutX(screenWidth*.05);

            underObjectToolSelect.setLayoutX(screenWidth*.05);
            underObjectToolSelect.setLayoutY(screenHeigth*.916);
            underObjectToolSelect.setMinWidth(screenWidth*.95);


    }


}
