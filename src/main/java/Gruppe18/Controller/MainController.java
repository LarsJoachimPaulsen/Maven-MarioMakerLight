package Gruppe18.Controller;

import Gruppe18.Data.*;
import Gruppe18.FileHandeling.Writer_Reader;
import Gruppe18.Settings.*;
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


import java.nio.file.Path;


public class MainController implements EventHandler<KeyEvent> {

    @FXML
    private Button btnConfirm;
    @FXML
    public ImageView playableCharacterSprite;
   @FXML
    protected ImageView enemySprite;
    @FXML
    protected ImageView carSprite;
    @FXML
    protected ListView<String> toolSelect = new ListView<>();
    @FXML
    protected Label toolSelectedLabel;
    @FXML
    protected ListView<String> underCharacterToolSelect = new ListView<>();
    @FXML
    protected ListView<ImageView> underObjectToolSelect = new ListView<>();
    @FXML
    protected Label txtPoints;
    @FXML
    protected Button btnExitGame;
    @FXML
    protected Label collisionTestText;

    private int characterMovementSpeed = 10;


    private ObservableList<String> toolList = FXCollections.observableArrayList("Pointer","Objects","PlayerCharacters","Enemies","Cars","Backgrounds");
    private ObservableList<String> underObjectToolList = FXCollections.observableArrayList("Square","Circle","Triangle");
    //private ObservableList<ImageView> objectListPhoto = FXCollections.observableArrayList();

    private ObservableList<PlayerCharacter> playerCharactersList = FXCollections.observableArrayList(Writer_Reader.getPlayableCharacters());
    private ObservableList<ImageView> playerCharacterListPhoto = FXCollections.observableArrayList();
    //private ObservableList<String> playerCharacterListNames = FXCollections.observableArrayList();

    private ObservableList<Enemy> enemyList = FXCollections.observableArrayList(Writer_Reader.getEnemyCharacters());
    private ObservableList<ImageView> enemyListPhoto = FXCollections.observableArrayList();
    //private ObservableList<String> enemyListNames = FXCollections.observableArrayList();

    private ObservableList<Car> carList = FXCollections.observableArrayList(Writer_Reader.getCarCharacters());
    private ObservableList<ImageView> carListPhoto = FXCollections.observableArrayList();
    //private ObservableList<String> carListNames = FXCollections.observableArrayList();

    protected double screenWidth = Screen.getPrimary().getBounds().getWidth();
    protected double screenHeight =  Screen.getPrimary().getBounds().getHeight();

    private String currentOrientationOfToolBar = "";

    public void initialize() {

        //testkode - karakteren på skjermen
        playableCharacterSprite.setFocusTraversable(true);
        playableCharacterSprite.setImage(new Image(playerCharactersList.get(0).getPhoto()));

        // playableCharacterSprite.setImage(new Image("/Pictures/PlayableCharacters/aleksander.png"));
        playableCharacterSprite.setFitHeight(playerCharactersList.get(0).getSize()*10);
        characterMovementSpeed = playerCharactersList.get(0).getMovementSpeed();

        enemySprite.setImage(new Image(enemyList.get(0).getPhoto()));
        enemySprite.setFitHeight(enemyList.get(0).getSize()*10);

        carSprite.setImage(new Image(carList.get(0).getPhoto()));
        carSprite.setFitHeight(carList.get(0).getHeight()*10);

        setUpButtons();

        toolSelect.setItems(toolList);
        for(int i = 0; i < playerCharactersList.size(); i++) {
            playerCharacterListPhoto.add(new ImageView(playerCharactersList.get(i).getPhoto()));
        }
        for(int j = 0; j < enemyList.size(); j++) {
            enemyListPhoto.add(new ImageView(enemyList.get(j).getPhoto()));
        }
        for(int k = 0; k < carList.size(); k++) {
            carListPhoto.add(new ImageView(carList.get(k).getPhoto()));
        }

        //sjekker hvilken som har blitt valgt i toolSelect
        toolSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            ImageView imageView = new ImageView();
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue ) {
                toolSelectedLabel.setText(newValue);
                if(newValue.equals("Objects")) {
                    underObjectToolSelect.setVisible(true);
                    //underObjectToolSelect.setItems(underObjectToolList);
                }
                else if(newValue.equals("PlayerCharacters")){
                    underObjectToolSelect.setVisible(true);
                    underObjectToolSelect.setItems(playerCharacterListPhoto);
                    //addPlayerCharactersToToolbar();0
                }
                else if(newValue.equals("Enemies")) {
                    underObjectToolSelect.setVisible(true);
                    underObjectToolSelect.setItems(enemyListPhoto);
                }
                else if(newValue.equals("Cars")) {
                    underObjectToolSelect.setVisible(true);
                    underObjectToolSelect.setItems(carListPhoto);
                }
                /*else if(newValue.equals("Backgrounds")) {
                    underObjectToolSelect.setVisible(true);
                    underObjectToolSelect.setItems(backgroundList);
                }*/
                else {
                    underObjectToolSelect.setVisible(false);
                    underObjectToolSelect.setItems(null);
                }
            }
        });
    }

    @Override
    public void handle(KeyEvent keyEvent){

    }

    /**
     * @author Lars
     */
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

    /**
     * @author Lars
     */
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
                        checkCollision(1);
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
                        checkCollision(2);
                        break;
                    case W:
                        if (playableCharacterSprite.getY() < -(toolSelect.getHeight())){
                            playableCharacterSprite.setY(scene.getHeight());
                        }
                        else if (playableCharacterSprite.getY() < -260) {
                            return;
                        }
                        else {
                            playableCharacterSprite.setY(playableCharacterSprite.getY() - characterMovementSpeed);
                        }

                        keyEvent.consume();
                        checkCollision(3);
                        break;
                    case S:
                        if (playableCharacterSprite.getY() > scene.getHeight()){
                            playableCharacterSprite.setY(0);
                        }
                        else if (playableCharacterSprite.getY() > 665) {
                            return;
                        }
                        else {
                        playableCharacterSprite.setY(playableCharacterSprite.getY() + characterMovementSpeed);
                        }
                        keyEvent.consume();
                        checkCollision(4);
                        break;
                }

            }
        });

    }

    /**
     * @author Lars
     */
    private void exitGame(){
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

    // Adding new ImageViews containing player sprites, based on how many exists. Currently not working
    private void addPlayerCharactersToToolbar() {

        for (int i = 0; i<playerCharactersList.size(); i++){
           // String name = String.valueOf(i);
            ImageView name  = new ImageView();
            name.setImage(new Image(playerCharactersList.get(i).getPhoto()));
           // name.setX((screenWidth/2)/(double)playerCharacters.size());
            name.setLayoutY(screenHeight/2);
            name.setLayoutX(screenWidth/2);
           // name.setLayoutX(screenWidth*.05 + screenWidth/(double)playerCharacters.size());
        }

    }

    /**
     * @author Lars
     */
    private void setUpButtons() {
        btnConfirm.setLayoutY(screenHeight/2);
        btnConfirm.setLayoutX(screenWidth/2);

        btnExitGame.setLayoutY(30);
        btnExitGame.setLayoutX(screenWidth-50);

        // input left, right, top, bottom
        Settings.setOrientationOfToolBar(toolSelect, "right");
         //setOrientationOfToolBar("left");
        toolSelectedLabel.setLayoutX(screenWidth*.05);

        //input left, right, top, bottom
        //setOriontationOfSecondaryToolBar("left");

        // må fikses noe bugs
        Settings.setOriontationOfSecondaryToolBar(underObjectToolSelect, "bottom");
    }

    // test for collision

    /**
     *
     * @param direction a test for checking the direction of the collision
     * @author Lars
     */
    private void checkCollision(int direction){

        if (playableCharacterSprite.getBoundsInParent().intersects(enemySprite.getBoundsInParent())){
            if (direction == 1){
                collisionTestText.setText("Collision From right");
            }
            else if(direction == 2){
                collisionTestText.setText("Collision from Left");
            }
            else if (direction == 3){
                collisionTestText.setText("Collision from top");
            }
            else if(direction == 4){
                collisionTestText.setText("Collision from bottom");
            }

        }
    }

    // Må ha fixes for å få riktig orientation på tekst. Skal inn i settings!
    /*
    public void setOrientationOfToolBar(String orientation){

        boolean trigger = false;
        switch (orientation.toLowerCase()){

            case "left" :
                toolSelect.setMinHeight(screenHeigth);
                toolSelect.setMinWidth(screenWidth*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "l";
                trigger = true;
                break;

            case "right" :
                toolSelect.setMinHeight(screenHeigth);
                toolSelect.setMinWidth(screenWidth*.05);
                toolSelect.setLayoutX(screenWidth-125);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "r";
                trigger = true;
                break;

            case "top" :
                toolSelect.setMinWidth(screenWidth);
                toolSelect.setMinHeight(screenHeigth*.05);
                toolSelect.setMaxHeight(screenHeigth*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "t";
                trigger = true;
                break;

            case "bottom" :
                toolSelect.setMinWidth(screenWidth);
                toolSelect.setMinHeight(screenHeigth*.05);
                toolSelect.setMaxHeight(screenHeigth*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(screenHeigth-125);
                currentOrientationOfToolBar = "b";
                trigger = true;
                break;

        }
        if(!trigger){
            System.out.println("Error in setOnOrientationOfToolbar!! String value needs to be top, bottom, left or right");
        }

    }

    // skal flyttes til innstillinger
    public void setOriontationOfSecondaryToolBar(String oriantation) {

       boolean trigger = false;

        switch (oriantation.toLowerCase()){
            case "left" :
                if (currentOrientationOfToolBar.toLowerCase().equals("l")){

                    underObjectToolSelect.setLayoutX(toolSelect.getMinWidth());
                    toolSelectedLabel.setLayoutX(toolSelect.getMinWidth()*2);
                }
                else{
                    underObjectToolSelect.setLayoutX(0);

                }
                underObjectToolSelect.setLayoutY(0);
                underObjectToolSelect.setMinHeight(screenHeigth);
                underObjectToolSelect.setMaxWidth(screenWidth*0.05);
                trigger = true;
                break;

            case "right" :
                if (currentOrientationOfToolBar.toLowerCase().equals("r")){
                    underObjectToolSelect.setLayoutX(screenWidth - screenWidth*.1);
                }
                else {
                    underObjectToolSelect.setLayoutX(screenWidth-125);

                }
                underObjectToolSelect.setLayoutY(0);
                underObjectToolSelect.setMinHeight(screenHeigth);
                underObjectToolSelect.setMaxWidth(screenWidth*.05);
                trigger = true;
                break;

            case "top" :
                if (currentOrientationOfToolBar.toLowerCase().equals("t")){
                    underObjectToolSelect.setLayoutY(toolSelect.getMaxHeight());
                    System.out.println(toolSelect.getMaxHeight());
                }
                else {
                    underObjectToolSelect.setLayoutY(0);
                }
                underObjectToolSelect.setLayoutX(0);
                underObjectToolSelect.setMinWidth(screenWidth);
                underObjectToolSelect.setMaxHeight(screenHeigth*.05);
                trigger = true;
                break;

            case "bottom" :
                if (currentOrientationOfToolBar.toLowerCase().equals("b")){
                    underObjectToolSelect.setLayoutY(screenHeigth-125 - toolSelect.getMaxHeight());
                }
                else {
                    underObjectToolSelect.setLayoutY(screenHeigth-125);
                }
                underObjectToolSelect.setLayoutX(0);
                underObjectToolSelect.setMinWidth(screenWidth);
                underObjectToolSelect.setMaxHeight(screenHeigth*.05);
                trigger = true;
                break;
        }

        if(!trigger){
            System.out.println("Error in setOrientationOfSecondaryToolbar! String value needs to be left, right, top or bottom");
        }
    }
    */
    public void help(){
        // method a user can call to get help with the class in question. Will be printed in console
    }
}
