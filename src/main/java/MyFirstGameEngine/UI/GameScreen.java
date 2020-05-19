package MyFirstGameEngine.UI;

import MyFirstGameEngine.GamescreenController.GameScreenController;
import MyFirstGameEngine.Settings.Settings;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.fxml.FXMLLoader;


public final class GameScreen extends Application {

   // Background defaultBackground = new Background();
    String pathToFile = Settings.getProgramIcon();

    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Main.fxml"));
            Parent root = fxmlLoader.load();
           GameScreenController controller = fxmlLoader.getController();

            BackgroundImage background = new BackgroundImage(new Image("Pictures/Backgrounds/defaultBackground.png",32,32,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);



           controller.setStage(primaryStage);
            primaryStage.getIcons().add(new Image(pathToFile));
            primaryStage.setTitle("My first game maker!");


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


