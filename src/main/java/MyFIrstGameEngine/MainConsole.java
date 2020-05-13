package MyFIrstGameEngine;

import MyFIrstGameEngine.CharacterCreation.PlayerCharacter;
import MyFIrstGameEngine.CharacterCreation.PlayerCharacterBuilder;
import MyFIrstGameEngine.Data.GameLauncher;
//import Gruppe18.Settings.Settings;


import static javafx.application.Application.launch;

public class MainConsole {




    public static void main(String[] args){

        GameLauncher.launchGame(new GameScreen());


        PlayerCharacterBuilder pc = new PlayerCharacterBuilder()
                .name("kai")
                .damage(30)
                .enableScore()
                .movementSpeed(30);
        PlayerCharacter kai = pc.createPlayerCharacter();

        kai.getInformation();

        /*
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

       Serializable.writeCharacterToFile(mario);


        //System.out.println(mariu.isScoreEneabled());

        EnemyBuilder enemy = new EnemyBuilder()
                .name("goomber")
                .maxHealth(40)
                .damage(10)
                .pointValue(30);
        Enemy goomber = enemy.createEnemy();

        System.out.println(goomber.getName());
        Serializable.writeCharacterToFile(goomber);

        EnemyBuilder enemy2 = new EnemyBuilder()
                .name("kopra")
                .maxHealth(50)
                .damage(20)
                .pointValue(20);
        Enemy kopra = enemy2.createEnemy();
        Serializable.writeCharacterToFile(kopra);

        CarBuilder c = new CarBuilder()
                .name("subaru")
                .damage(100)
                .health(300);
        Car subaru = c.createCar();

        System.out.println(subaru);
        System.out.println(subaru.getName());
        subaru.getInformation();
        Serializable.writeCharacterToFile(subaru);


       ArrayList<PlayerCharacter> playerList = Serializable.getPlayableCharacters();

       for(PlayerCharacter list : playerList){
           list.getInformation();
       }

        ArrayList<Enemy> enemyList = Serializable.getEnemyCharacters();

       for(Enemy list : enemyList){
           list.getInformation();
       }

       ArrayList<Car> carList = Serializable.getCarCharacters();

       for(Car list : carList){
           list.getInformation();
       }


       GameScreen newGameScreen = new GameScreen();

       GameLauncher.launchGame(newGameScreen);

       Settings.help("setOrientationOfToolBar");




/      for(PlayerCharacter player : playerList){
            player.getInformation();
        }



       System.out.println(writer.lesFraFil());


         */

        /*Integer[] highscore = new Integer[10];


        for(int i = 0; i < 10; i++){
            Double t = Math.random()*1000;
            highscore[i] = Integer.parseInt(String.valueOf(t));

        }

        Serializable.writeHighScore(highscore);

        Integer[] higscoreOut = Serializable.getHighscoreList();

        for (int high: higscoreOut) {
            System.out.println(high);
        }

         */

      PlayerCharacterBuilder builder = new PlayerCharacterBuilder()
              .damage(50)
              .enableScore()
              .name("TestPlayer")
              .maxHealth(100);
      PlayerCharacter player = builder.createPlayerCharacter();

        //Settings.setOrientationOfToolBar("top");


    }
}
