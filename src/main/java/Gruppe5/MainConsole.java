package Gruppe5;

import Gruppe5.Data.*;
import Gruppe5.Model.*;

public class MainConsole {

    public static void main(String[] args){

        PlayerCharacterBuilder p = new PlayerCharacterBuilder()
                .name("mariu")
                .damage(20)
                .enableScore()
                .maxHealth(30)
                .size(10);
        PlayerCharacter mariu = p.createPlayerCharacter();

        mariu.getInformation();
        System.out.println(mariu.toString());

        Writer_Reader writer = new Writer_Reader();

        writer.writeCharacterToFil(mariu);


        //System.out.println(mariu.isScoreEneabled());

        EnemyBuilder enemy = new EnemyBuilder()
                .name("goomber")
                .maxHealth(40)
                .damage(10)
                .pointValue(30);
        Enemy goomber = enemy.createEnemy();

        System.out.println(goomber.getName());
        writer.writeCharacterToFil(goomber);

        CarBuilder c = new CarBuilder()
                .name("subaru")
                .damage(100)
                .health(300);
        Car subaru = c.createCar();

        System.out.println(subaru);
        System.out.println(subaru.getName());
        subaru.getInformation();
        writer.writeCharacterToFil(subaru);

        //System.out.println(writer.lesFraFil());

    }
}
