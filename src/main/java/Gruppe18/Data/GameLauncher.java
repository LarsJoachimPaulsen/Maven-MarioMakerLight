package Gruppe18.Data;

import Gruppe18.GameScreen;

import static javafx.application.Application.launch;

public abstract class GameLauncher {

    public static void launchGame(GameScreen s){
        launch(s.getClass());
    }
}
