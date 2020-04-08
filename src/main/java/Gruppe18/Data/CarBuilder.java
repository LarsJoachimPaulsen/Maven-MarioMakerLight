package Gruppe18.Data;

import javafx.scene.image.Image;

public class CarBuilder {

    Car car = new Car();

    public CarBuilder name(String name){
        car.name = name;
        return this;
    }

    public CarBuilder health(int health){
        car.health = health;
        return this;
    }

    public CarBuilder damage(int damage){
        car.damage = damage;
        return this;
    }

    public CarBuilder height(int height){
        car.height = height;
        return this;
    }

    public CarBuilder width(int width){
        car.width = width;
        return this;
    }

    public CarBuilder photo(String photo){
        car.photo = photo;
        return this;
    }

    public void reset(){
        this.car = new Car();
    }

    public Car createCar(){
        Car c = this.car;
        this.reset();
        return c;
    }

}
