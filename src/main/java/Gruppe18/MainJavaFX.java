package Gruppe18;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.fxml.FXMLLoader;


public class MainJavaFX extends Application {

        @Override
        public void start(Stage primaryStage) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
                primaryStage.getIcons().add(new Image("Pictures/logo.png"));
                primaryStage.setTitle("Mario Maker Light");

                double maxX = Screen.getPrimary().getVisualBounds().getMaxX();
                double maxY = Screen.getPrimary().getVisualBounds().getMaxY()-10;

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


