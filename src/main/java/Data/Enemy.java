package Data;

import javafx.scene.image.Image;

public final class Enemy {

    String name;
    int health;
    int damage;
    int pointValue;
    int size;
    Image photo;

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
