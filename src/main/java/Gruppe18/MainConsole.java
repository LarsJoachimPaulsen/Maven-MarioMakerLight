package Gruppe18;

import Gruppe18.Data.*;
import Gruppe18.FileHandeling.Writer_Reader;
import Gruppe18.Settings.Settings;

import java.util.ArrayList;

public class MainConsole {

    public static void main(String[] args){

        PlayerCharacterBuilder p = new PlayerCharacterBuilder()
                .name("mario")
                .damage(30)
                .disableScore()
                .movementSpeed(10)
                .maxHealth(100)
                .size(10);
        PlayerCharacter mario = p.createPlayerCharacter();

        mario.getInformation();
        System.out.println(mario.toString());

        //Writer_Reader writer = new Writer_Reader();

       Writer_Reader.writeCharacterToFile(mario);


        //System.out.println(mariu.isScoreEneabled());

        EnemyBuilder enemy = new EnemyBuilder()
                .name("goomber")
                .maxHealth(40)
                .damage(10)
                .pointValue(30);
        Enemy goomber = enemy.createEnemy();

        System.out.println(goomber.getName());
        Writer_Reader.writeCharacterToFile(goomber);

        EnemyBuilder enemy2 = new EnemyBuilder()
                .name("kopra")
                .maxHealth(50)
                .damage(20)
                .pointValue(20);
        Enemy kopra = enemy2.createEnemy();
        Writer_Reader.writeCharacterToFile(kopra);

        CarBuilder c = new CarBuilder()
                .name("subaru")
                .damage(100)
                .health(300);
        Car subaru = c.createCar();

        System.out.println(subaru);
        System.out.println(subaru.getName());
        subaru.getInformation();
        Writer_Reader.writeCharacterToFile(subaru);


       ArrayList<PlayerCharacter> playerList = Writer_Reader.getPlayableCharacters();

       for (int i = 0; i<playerList.size(); i++){
           playerList.get(i).getInformation();
       }

        ArrayList<Enemy> enemyList = Writer_Reader.getEnemyCharacters();

       for(int i = 0; i<enemyList.size(); i++){
           enemyList.get(i).getInformation();
       }

       ArrayList<Car> carList = Writer_Reader.getCarCharacters();

       for(int i = 0; i<carList.size(); i++){
           carList.get(i).getInformation();
       }
       MainJavaFX newGame = new MainJavaFX();






/*        for(PlayerCharacter player : playerList){
            player.getInformation();
        } */



       // System.out.println(writer.lesFraFil());

    }
}
