package MyFIrstGameEngine.Controller;

import MyFIrstGameEngine.Data.*;
import MyFIrstGameEngine.FileHandeling.Serializable;
import MyFIrstGameEngine.Settings.Orientation;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Settings implements EventHandler<KeyEvent> {

    @FXML
    private Button btnConfirm;
    @FXML
    private ImageView playableCharacterSprite;
   @FXML
    private ImageView enemySprite;
    @FXML
    private ImageView carSprite;
    @FXML
    private ListView<String> toolSelect = new ListView<>();
    @FXML
    private ListView<ImageView> underToolSelect = new ListView<>();
    @FXML
    private Label txtPoints;
    @FXML
    private Button btnExitGame;
    @FXML
    private Label collisionTestText;
    @FXML
    private ListView<Integer> highscoreView = new ListView<>();

    private Stage scene;



    private int characterMovementSpeed = 10;

    private PlayerCharacter selectedPlayer;


    public ObservableList<String> toolList = FXCollections.observableArrayList("Pointer","Objects","PlayerCharacters","Enemies","Cars","Backgrounds");
    private ObservableList<String> underObjectToolList = FXCollections.observableArrayList("Square","Circle","Triangle");
    //private ObservableList<ImageView> objectListPhoto = FXCollections.observableArrayList();

    private ObservableList<PlayerCharacter> playerCharactersList = FXCollections.observableArrayList(Serializable.getPlayableCharacters());
    private ObservableList<ImageView> playerCharacterListPhoto = FXCollections.observableArrayList();
    //private ObservableList<String> playerCharacterListNames = FXCollections.observableArrayList();

    private ObservableList<Enemy> enemyList = FXCollections.observableArrayList(Serializable.getEnemyCharacters());
    private ObservableList<ImageView> enemyListPhoto = FXCollections.observableArrayList();
    //private ObservableList<String> enemyListNames = FXCollections.observableArrayList();

    private ObservableList<Car> carList = FXCollections.observableArrayList(Serializable.getCarCharacters());
    private ObservableList<ImageView> carListPhoto = FXCollections.observableArrayList();
    //private ObservableList<String> carListNames = FXCollections.observableArrayList();

    private ObservableList<Integer> highscoreList = FXCollections.observableArrayList(Serializable.getHighscoreList());

    private double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private double screenHeight =  Screen.getPrimary().getBounds().getHeight();





    private String currentOrientationOfToolBar = "";


    public void initialize() {

        //testkode - karakteren på skjermen
        playableCharacterSprite.setFocusTraversable(true);

        selectedPlayer = playerCharactersList.get(0);

        playableCharacterSprite.setImage(new Image(selectedPlayer.getPhoto()));

        // playableCharacterSprite.setImage(new Image("/Pictures/PlayableCharacters/aleksander.png"));
        playableCharacterSprite.setFitHeight(playerCharactersList.get(0).getSize() * 10);
        characterMovementSpeed = playerCharactersList.get(0).getMovementSpeed();

        enemySprite.setImage(new Image(enemyList.get(0).getPhoto()));
        enemySprite.setFitHeight(enemyList.get(0).getSize() * 10);

        carSprite.setImage(new Image(carList.get(0).getPhoto()));https:
        carSprite.setFitHeight(carList.get(0).getHeight() * 10);

        setUpButtons();

        toolSelect.setItems(toolList);
        for (int i = 0; i < playerCharactersList.size(); i++) {
            playerCharacterListPhoto.add(new ImageView(playerCharactersList.get(i).getPhoto()));
        }
        for (int j = 0; j < enemyList.size(); j++) {
            enemyListPhoto.add(new ImageView(enemyList.get(j).getPhoto()));
        }
        for (int k = 0; k < carList.size(); k++) {
            carListPhoto.add(new ImageView(carList.get(k).getPhoto()));
        }

        /**
         * @author Christine
         */
        //sjekker hvilken som har blitt valgt i toolSelect
        toolSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            ImageView imageView = new ImageView();

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("Objects")) {
                    underToolSelect.setVisible(true);
                    //underObjectToolSelect.setItems(underObjectToolList);
                } else if (newValue.equals("PlayerCharacters")) {
                    underToolSelect.setVisible(true);
                    underToolSelect.setItems(playerCharacterListPhoto);
                    //addPlayerCharactersToToolbar();0
                } else if (newValue.equals("Enemies")) {
                    underToolSelect.setVisible(true);
                    underToolSelect.setItems(enemyListPhoto);
                } else if (newValue.equals("Cars")) {
                    underToolSelect.setVisible(true);
                    underToolSelect.setItems(carListPhoto);
                }
                /*else if(newValue.equals("Backgrounds")) {
                    underObjectToolSelect.setVisible(true);
                    underObjectToolSelect.setItems(backgroundList);
                }*/
                else {
                    underToolSelect.setVisible(false);
                    underToolSelect.setItems(null);
                }
            }
        });

//        scene.widthProperty().addListener(stageSizeListener);
  //      scene.heightProperty().addListener(stageSizeListener);
    }

    private void getScene() {
        scene = (Stage)btnConfirm.getScene().getWindow();
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
      underToolSelect.setVisible(false);
      txtPoints.setVisible(true);
      highscoreView.setVisible(false);
      txtPoints.setText("");
      playableCharacterSprite.requestFocus();
      enableWalking();

    }

    ChangeListener<Number> stageSizeListener = ((observableValue, number, t1) ->
                System.out.println("height " + scene.getHeight() + "Width " + scene.getWidth())
    );


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
    public void exitGame(){
        btnConfirm.setVisible(true);
        btnExitGame.setVisible(false);
        toolSelect.setVisible(true);

        underToolSelect.setVisible(true);
        txtPoints.setVisible(false);
        removeWalking();
        gameOver();
    }

    public void gameOver(){

        //sort highscores
        sortHighscores(300);
        //set the view to visible
        highscoreView.setVisible(true);
        //add highscores to view
        highscoreView.setItems(highscoreList);

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
        btnConfirm.setLayoutY(screenWidth/2);
        btnConfirm.setLayoutX(screenHeight/2);

        btnExitGame.setLayoutY(30);
        btnExitGame.setLayoutX(screenWidth-50);

        // input left, right, top, bottom
        setOrientationOfToolBar(Orientation.TOP);
         //setOrientationOfToolBar("left");


        //input left, right, top, bottom
        //setOriontationOfSecondaryToolBar("left");

        // må fikses noe bugs
        setOriontationOfSecondaryToolBar(Orientation.);
    }

    // test for collision

    /**
     *
     * @param direction a test for checking the direction of the collision
     * @author Lars
     */
    private void checkCollision (int direction){

        if (playableCharacterSprite.getBoundsInParent().intersects(enemySprite.getBoundsInParent())) {
            if (direction == 1) {
                collisionTestText.setText("Collision From right");
            } else if (direction == 2) {
                collisionTestText.setText("Collision from Left");
            } else if (direction == 3) {
                collisionTestText.setText("Collision from top");
            } else if (direction == 4) {
                collisionTestText.setText("Collision from bottom");
            }


        }
    }

    /**
     *
     * @author Lars
     */
    private void sortHighscores(int playerScore) {

        Integer[] highscoreArray = new Integer[10];

        for(int i = 0; i<highscoreList.size(); i++){
            highscoreArray[i] = highscoreList.get(i);
        }

      for(int i = 0; i < highscoreArray.length; i++){
          if(playerScore > highscoreArray[i]){
              int temp = highscoreArray[i];
              highscoreArray[i] = playerScore;
              playerScore = temp;
          }
      }
       for(int i = 0; i < highscoreArray.length; i++){
            for(int j = 0; j<highscoreArray.length; j++){
                if (highscoreArray[i] > highscoreArray[j]){
                    int temp = highscoreArray[i];
                    highscoreArray[i] = highscoreArray[j];
                    highscoreArray[j] = temp;
                }
            }
        }

       highscoreList = FXCollections.observableArrayList(highscoreArray);

       Serializable.writeHighScore(highscoreArray);

    }

    public void setOrientationOfToolBar(Orientation orientation){

        switch (orientation){

            case LEFT:
                toolSelect.setMinHeight(screenHeight);
                toolSelect.setMinWidth(screenWidth*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "l";

                break;

            case RIGHT:
                toolSelect.setMinHeight(screenHeight);
                toolSelect.setMinWidth(screenWidth*.05);
                toolSelect.setLayoutX(screenWidth-125);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "r";
                break;

            case TOP :
                toolSelect.setMinWidth(screenWidth);
                toolSelect.setMinHeight(screenHeight*.05);
                toolSelect.setMaxHeight(screenHeight*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "t";
                break;

            case BOTTOM :
                toolSelect.setMinWidth(screenWidth);
                toolSelect.setMinHeight(screenHeight*.05);
                toolSelect.setMaxHeight(screenHeight*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(screenHeight-125);
                currentOrientationOfToolBar = "b";
                break;

            default:
                System.out.println("Error in setOnOrientationOfToolbar!! Orientation value needs to be TOP, BOTTOM, LEFT or RIGHT");
                break;

        }
    }

    // skal flyttes til innstillinger
    public void setOriontationOfSecondaryToolBar(Orientation orientation) {



        switch (orientation){
            case LEFT :
                if (currentOrientationOfToolBar.toLowerCase().equals("l")){

                    underToolSelect.setLayoutX(toolSelect.getMinWidth());


                }
                else{
                    underToolSelect.setLayoutX(0);

                }
                underToolSelect.setLayoutY(0);
                underToolSelect.setMinHeight(screenHeight);
                underToolSelect.setMaxWidth(screenWidth*0.05);

                break;

            case RIGHT :
                if (currentOrientationOfToolBar.toLowerCase().equals("r")){
                    underToolSelect.setLayoutX(screenWidth - screenWidth*.1);
                }
                else {
                    underToolSelect.setLayoutX(screenWidth-125);

                }
                underToolSelect.setLayoutY(0);
                underToolSelect.setMinHeight(screenHeight);
                underToolSelect.setMaxWidth(screenWidth*.05);

                break;

            case TOP :
                if (currentOrientationOfToolBar.toLowerCase().equals("t")){
                    underToolSelect.setLayoutY(toolSelect.getMaxHeight());
                    System.out.println(toolSelect.getMaxHeight());
                }
                else {
                    underToolSelect.setLayoutY(0);
                }
                underToolSelect.setLayoutX(0);
                underToolSelect.setMinWidth(screenWidth);
                underToolSelect.setMaxHeight(screenHeight*.05);

                break;

            case BOTTOM :
                if (currentOrientationOfToolBar.toLowerCase().equals("b")){
                    underToolSelect.setLayoutY(screenHeight-125 - toolSelect.getMaxHeight());
                }
                else {
                    underToolSelect.setLayoutY(screenHeight-125);
                }
                underToolSelect.setLayoutX(0);
                underToolSelect.setMinWidth(screenWidth);
                underToolSelect.setMaxHeight(screenHeight*.05);
                break;

            default:
                System.out.println("Error in setOrientationOfSecondaryToolbar! String value needs to be left, right, top or bottom");
                break;
        }

    }

    public void help(){
        // method a user can call to get help with the class in question. Will be printed in console
    }



    public void setStage(Stage stage){
        this.scene = stage;
    }

}
