package Gruppe18.Data;

import java.io.*;

public final class PlayerCharacter implements java.io.Serializable {

    String name;
    int maxHealth = 50;
    int currentHeath = 50;
    int movementSpeed = 10;
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

    public void saveCharacterToFile(){
        File file = new File("src/main/resources/Files/PlayableCharacter.txt");

        try {
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(name);
            br.write(maxHealth);
            br.write(currentHeath);
            br.write(movementSpeed);
            br.write(damage);
            br.write(size);
            br.write(String.valueOf(scoreEneabled));
            br.write(String.valueOf(points));
            br.write(photo);
        }
        catch (IOException IOE){
            IOE.printStackTrace();
        }


    }


}
