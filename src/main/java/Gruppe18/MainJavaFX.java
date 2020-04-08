package Gruppe18;

import Gruppe18.Data.Background;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.fxml.FXMLLoader;


public class MainJavaFX extends Application {

    Background defaultBackground = new Background();

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            primaryStage.getIcons().add(new Image("Pictures/Icons/logo.png"));
            primaryStage.setTitle("Mario Maker Light");

            double maxX = Screen.getPrimary().getBounds().getMaxX();
            double maxY = Screen.getPrimary().getBounds().getMaxY()-10;

            Scene scene = new Scene(root, maxX , maxY);

            primaryStage.setScene(scene);





            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}


