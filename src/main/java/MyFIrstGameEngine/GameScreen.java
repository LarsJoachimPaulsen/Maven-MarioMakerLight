package MyFIrstGameEngine;

import MyFIrstGameEngine.Controller.Settings;
import MyFIrstGameEngine.Data.Background;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.fxml.FXMLLoader;


public final class GameScreen extends Application {



    Background defaultBackground = new Background();


    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Main.fxml"));
            Parent root = fxmlLoader.load();
           Settings controller = fxmlLoader.getController();

           controller.setStage(primaryStage);
            primaryStage.getIcons().add(new Image("Pictures/Icons/logo.png"));
            primaryStage.setTitle("Mario Maker Light");

            double maxX = Screen.getPrimary().getBounds().getMaxX();
            double maxY = Screen.getPrimary().getBounds().getMaxY()-10;

            scene = new Scene(root, maxX , maxY);

            primaryStage.setScene(scene);

            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void setScene(Scene scene){
        this.scene = scene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}


