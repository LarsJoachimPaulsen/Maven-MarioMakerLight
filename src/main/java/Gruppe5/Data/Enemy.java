package Gruppe5.Data;

import javafx.scene.image.Image;

public final class Enemy {

    String name;
    int health;
    int damage;
    int pointValue;
    int size;
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

    public int getPointValue() {
        return pointValue;
    }

    public int getSize() {
        return size;
    }

    public Image getPhoto() {
        return photo;
    }

    public void getInformation(){
        System.out.println();
    }
}
