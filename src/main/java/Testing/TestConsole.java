package Testing;

import MyFirstGameEngine.CharacterCreation.*;
import MyFirstGameEngine.FileHandeling.Serializable;
import MyFirstGameEngine.GameControlls.GameLauncher;
import MyFirstGameEngine.Settings.Settings;
import MyFirstGameEngine.Settings.ToolbarOrientation;
import MyFirstGameEngine.UI.GameScreen;
//import Gruppe18.Settings.Settings;


import java.util.ArrayList;

import static javafx.application.Application.launch;

public class TestConsole {




    public static void main(String[] args){

        PlayerCharacterBuilder pc = new PlayerCharacterBuilder()
                .name("TestPlayer")
                .damage(30)
                .enableScore()
                .jumpHeight(20)
                .maxHealth(250)
                .movementSpeed(10)
                .size(20);
        PlayerCharacter playerCharacter = pc.createPlayerCharacter();

        EnemyBuilder enemyBuilder = new EnemyBuilder()
                .name("TestEnemy")
                .damage(15)
                .maxHealth(50)
                .pointValue(100);
        Enemy  testEnemy = enemyBuilder.createEnemy();

        CarBuilder carBuilder = new CarBuilder()
                .name("TestCar")
                .damage(400)
                .health(600)
                .height(50)
                .speed(25);
        Car testCar = carBuilder.createCar();

        Settings.setOrientationOfMainToolbar(ToolbarOrientation.RIGHT);
        Settings.setOrientationOfSecondaryToolbar(ToolbarOrientation.LEFT);

        Settings.setProgramIcon("Pictures/Icons/logo.png");

        playerCharacter.getInformation();

        System.out.println(testEnemy.toString());

        testCar.getInformation();

        Serializable.writeCharacterToFile(playerCharacter);
        //Serializable.writeCharacterToFile(testEnemy);
        //Serializable.writeCharacterToFile(testCar);

        ArrayList<PlayerCharacter> playerList = Serializable.getPlayableCharacters();

        for(PlayerCharacter pcList : playerList){
            System.out.println(pcList.toString());
        }

        ArrayList<Enemy> enemiesList = Serializable.getEnemyCharacters();

        for(Enemy enemyList : enemiesList){
            enemyList.getInformation();
        }

        ArrayList<Car> carList = Serializable.getCarCharacters();

        for (Car cars: carList){
            System.out.println(cars.toString());
        }

        GameScreen gameScreen = new GameScreen();

        GameLauncher.launchGame(gameScreen);






    }
}
