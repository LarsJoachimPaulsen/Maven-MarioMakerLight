package Gruppe18.Data;

import javafx.scene.image.Image;

public final class Enemy {

    String name;
    int maxHealth = 15;
    int currentHealth = 15;
    int damage = 2;
    int pointValue = 4;
    int size = 3;
    Image photo;

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth(){
        return currentHealth;
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
        System.out.println("Enemy name " + name + " Enemy's max health: " + maxHealth + "Enemey's current health: "
                + currentHealth + " Enemy's damage: " + damage + " point value when killed: " + pointValue +
                " Enemy's size: " + size);
    }

    @Override
    public String toString(){
        return "Enemy name " + name + " Enemy's max health: " + maxHealth + "Enemey's current health: "
                + currentHealth + " Enemy's damage: " + damage + " point value when killed: " + pointValue +
                " Enemy's size: " + size;
    }
}