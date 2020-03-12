
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import javax.print.attribute.standard.Media;
import java.nio.file.Paths;


public class MainJavaFX extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            primaryStage.setTitle("Mario Maker Light");
            primaryStage.setScene(new Scene(root, 600, 400));

            primaryStage.show();

        }


        public static void main(String[] args) {
            launch(args);
        }
    }


