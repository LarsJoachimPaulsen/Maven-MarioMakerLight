package Gruppe5.Data;

import javafx.scene.image.Image;

import java.io.*;

public final class PlayerCharacter {

    String name;
    int maxHealth = 50;
    int currentHeath = 50;
    int damage = 5;
    int size = 10;
    boolean scoreEneabled = true;
    long points = 0;
    Image photo = new Image("/Pictures/playerCharacter.png");

    public String getName() {
        return name;
    }

    public int getHealth() {
        return maxHealth;
    }

    public int getCurrentHeath(){
        return currentHeath;
    }

    public int getDamage() {
        return damage;
    }

    public int getSize() {
        return size;
    }

    public String isScoreEneabled() {
        if (scoreEneabled){
            return "points are enabled for this Character";
        }
        else {
            return "points are not enabled for this Character";
        }
    }

    public long getPoints() {
        return points;
    }

    public Image getPhoto() {
        return photo;
    }


    public void writeCharacterToGameFile(){

        try{
           BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/Files/PlayableCharacter.txt"));
           bw.write(name);
           bw.close();
        }
        catch (FileNotFoundException FNFE){
            System.out.println("The file could not be found");
        }
        catch (IOException IOE){
            IOE.printStackTrace();
        }

    }


    public void getInformation(){
        System.out.println("Name of character: " + name + " Character's max health: " + maxHealth +
                " Characters current Health: " + currentHeath + " Characters damage: " + damage + " Characters size: " + size +
                " " +isScoreEneabled());
    }

    @Override
    public String toString(){
        return "Name of character: " + name + " Character's max health: " + maxHealth +
                " Characters current Health: " + currentHeath + " Characters damage: " + damage + " Characters size: " + size +
                " " +isScoreEneabled();
    }
}

