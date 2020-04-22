package Gruppe18.Data;

import Gruppe18.MainJavaFX;

import static javafx.application.Application.launch;

public abstract class GameLauncher {

    public static void launchGame(MainJavaFX s){
        launch(s.getClass());
    }
}
