package Gruppe5;

import Gruppe5.Data.Enemy;
import Gruppe5.Data.EnemyBuilder;
import Gruppe5.Data.PlayerCharacter;
import Gruppe5.Data.PlayerCharacterBuilder;

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


    }
}
