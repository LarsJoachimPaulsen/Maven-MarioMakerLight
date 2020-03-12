package Gruppe5.Data;

import javafx.scene.image.Image;

public final class PlayerCharacter {

    String name;
    int health;
    int damage;
    int size;
    boolean scoreEneabled;
    long points;
    Image photo;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
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
}
