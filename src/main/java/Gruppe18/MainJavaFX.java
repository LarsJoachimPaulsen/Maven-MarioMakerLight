package Gruppe18;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class MainJavaFX extends Application {

        @Override
        public void start(Stage primaryStage) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
                primaryStage.getIcons().add(new Image("Pictures/enemy.png"));
                primaryStage.setTitle("Mario Maker Light");
                primaryStage.setScene(new Scene(root, 600, 400));


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

