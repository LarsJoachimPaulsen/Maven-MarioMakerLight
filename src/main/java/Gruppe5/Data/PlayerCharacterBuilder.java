package Gruppe5.Data;

import javafx.scene.image.Image;

public class PlayerCharacterBuilder {

    PlayerCharacter pc = new PlayerCharacter();

    public PlayerCharacterBuilder name(String name){
        pc.name = name;
        return this;
    }

    public PlayerCharacterBuilder maxHealth(int health){
        pc.maxHealth = health;
        pc.currentHeath = health;
        return this;
    }

    public PlayerCharacterBuilder damage(int damage){
        pc.damage = damage;
        return this;
    }

    public PlayerCharacterBuilder size(int size){
        pc.size = size;
        return this;
    }

    public PlayerCharacterBuilder enableScore(){
        pc.scoreEneabled = true;
        return this;
    }

    public PlayerCharacterBuilder disableScore(){
        pc.scoreEneabled = false;
        return this;
    }

    public PlayerCharacterBuilder photo(String photo){
        pc.photo = photo;
        return this;
    }

    public void reset(){
        this.pc = new PlayerCharacter();
    }

    public PlayerCharacter createPlayerCharacter(){

        PlayerCharacter p = this.pc;
        this.reset();
        return p;
    }



}
