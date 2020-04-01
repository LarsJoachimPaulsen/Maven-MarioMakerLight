package Gruppe5;

import Gruppe5.Data.*;
import javafx.stage.Stage;

public class MainConsole {

    public static void main(String[] args){

        PlayerCharacterBuilder p = new PlayerCharacterBuilder()
                .name("mariu")
                .damage(20)
                .enableScore()
                .maxHealth(30)
                .size(10);
        PlayerCharacter mariu = p.createPlayerCharacter();



        System.out.println(mariu.isScoreEneabled());

        EnemyBuilder enemy = new EnemyBuilder()
                .name("goomber")
                .maxHealth(40)
                .damage(10)
                .pointValue(30);
        Enemy goomber = enemy.createEnemy();

        System.out.println(goomber.getName());

        CarBuilder c = new CarBuilder()
                .name("subsub")
                .damage(100)
                .health(300);
        Car subsub = c.createCar();

        System.out.println(subsub);
        System.out.println(subsub.getName());
        subsub.getInformation();
    }
}
