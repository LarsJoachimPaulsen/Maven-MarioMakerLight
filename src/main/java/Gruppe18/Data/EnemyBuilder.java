package Gruppe18.Data;

import javafx.scene.image.Image;

public class EnemyBuilder {

    Enemy enemy = new Enemy();

    public EnemyBuilder name(String name){
        enemy.name = name;
        return this;
    }

    public EnemyBuilder maxHealth(int health){
        enemy.maxHealth = health;
        enemy.currentHealth = health;
        return this;
    }

    public EnemyBuilder damage(int damage){
        enemy.damage = damage;
        return this;
    }

    public EnemyBuilder pointValue(int pointValue){
        enemy.pointValue = pointValue;
        return this;
    }

    public EnemyBuilder photo(Image photo){
        enemy.photo = photo;
        return this;
    }

    public void reset(){
        this.enemy = new Enemy();
    }

    public Enemy createEnemy(){
        Enemy e = this.enemy;
        this.reset();
        return e;
    }
}
