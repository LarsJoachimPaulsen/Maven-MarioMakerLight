package MyFirstGameEngine.GameControlls;

import MyFirstGameEngine.UI.GameScreen;

import static javafx.application.Application.launch;

public abstract class GameLauncher {

    public static void launchGame(GameScreen gameScreen){
        launch(gameScreen.getClass());
    }
}
