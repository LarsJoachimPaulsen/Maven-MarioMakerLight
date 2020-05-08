package Gruppe18.Data;

import javafx.scene.image.Image;

/**
 * @author Lars
 */
public final class Car {

    String name;
    int health = 100;
    int damage = 25;
    int height = 10;
    int width = 10;
    int speed = 5;
    String photo = "/Pictures/CarCharacters/test.jpg";


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getSpeed() {
        return speed;
    }

    public String getPhoto() {
        return photo;
    }


    @Override
    public String toString(){
        return  "Car name " + name + " Car health " + health + " Car's damage " + damage + " Car's heigth "
                + height + " Car's width " + width + " Car's speed " + speed;
    }

    public void getInformation(){

        System.out.println("Car name " + name + " Car health " + health + " Car's damage " + damage + " Car's heigth "
                + height + " Car's width " + width + " Car's speed " + speed);
    }
}
