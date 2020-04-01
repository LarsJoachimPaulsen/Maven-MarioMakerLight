package Gruppe5.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    String photo = "/Pictures/playerCharacter.png";

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

    public String getPhoto() {
        return photo;
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

