package Gruppe18.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Writer_Reader {

    private ArrayList<PlayerCharacter> playableCharacters = new ArrayList<>();
    private ArrayList<Enemy> enemyCharacters = new ArrayList<>();
    private ArrayList<Car> carCharacters = new ArrayList<>();

    private ObservableList<PlayerCharacter> obsPlayableCharacter = FXCollections.observableArrayList();

    //This method will write a character to the correct file, if it does not already exist.
    public void writeCharacterToFil(Object character){

        boolean characterExists = false;
        File file = null;
            if (character instanceof PlayerCharacter ){

                //getPlayableCharacters();
                for (int i = 0; i < playableCharacters.size(); i++){
                        if(playableCharacters.get(i).getName().equals(((PlayerCharacter) character).getName())){
                            characterExists = true;
                            break;
                        }
                }
                if (characterExists){
                    System.out.println("Character exist");
                    return;
                }
                // legg sjekk om character er i Array
                // legg til character i Array.
                // skriv hele array.
                file = new File("src/main/resources/Files/PlayableCharacter.json");
            }
            else if(character instanceof  Enemy){
                for(int i = 0; i < enemyCharacters.size(); i++){
                    if (enemyCharacters.get(i).getName().equals(((Enemy) character).getName())){
                        characterExists = true;
                        break;
                    }
                }

                if (characterExists){
                    System.out.println("Character already exists");
                    return;
                }
                file = new File("src/main/resources/Files/Enemy.json");
            }
            else if(character instanceof Car){

                for (int i = 0; i < carCharacters.size(); i++){
                    if (carCharacters.get(i).getName().equals(((Car) character).getName())){
                        characterExists = true;
                        break;
                    }
                }

                if(characterExists){
                    System.out.println("The Character already exist");
                    return;
                }

                file = new File("src/main/resources/Files/Car.json");
            }

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        String jsonWriter = gson.toJson(character);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(jsonWriter);
        }
        catch (IOException IOE){
            IOE.printStackTrace();
        }
        catch (NullPointerException e){
            System.out.println("A path to the file containing this object does not exist");
        }

    }


    // HVORFOR KRÆSJER DENNE???????????

    public ObservableList<PlayerCharacter> getPlayableCharacters() {


        File file = new File("src/main/resources/Files/PlayableCharacter.json");

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String line = "";

        StringBuilder jsonTextFromFile = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                jsonTextFromFile.append(line);
            }

            PlayerCharacter[] playerList = gson.fromJson(jsonTextFromFile.toString(), PlayerCharacter[].class);

            obsPlayableCharacter.addAll(Arrays.asList(playerList));

            return obsPlayableCharacter;

        } catch (IOException IOE) {
            IOE.printStackTrace();

            return null;
        }

    }


    /*
    public ArrayList<Object> lesFraFil(String nameOfCharacterClass){

        File file = null;

        ArrayList<Object> characterList = new ArrayList<>();

        String identifier = "";

        switch (nameOfCharacterClass.toLowerCase()){

            case "playercharacter"
        }

        if ( characterFile instanceof PlayerCharacter ){
            file = new File("src/main/resources/Files/PlayableCharacter.json");
            identifier = "Playable Character";
        }
        else if(characterFile instanceof Enemy){
            file = new File("src/main/resources/Files/Enemy.json");
            identifier = "Enemy";
        }
        else if(characterFile instanceof Car){
            file = new File("src/main/resources/Files/Car.json");
            identifier = "Car";

        }

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String line = "";
        StringBuilder jsonTextFromFile = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while((line = br.readLine()) != null){
                jsonTextFromFile.append(line);
            }
            switch (identifier){

                case "Enemy" :
                    Enemy[] enemyArray = gson.fromJson(jsonTextFromFile.toString(), Enemy[].class);
                    characterList.addAll(Arrays.asList(enemyArray));
                    break;
                case "Car" :
                    Car [] carArray = gson.fromJson(jsonTextFromFile.toString(), Car[].class);
                    characterList.addAll(Arrays.asList(carArray));
                    break;
                case "Playable Character" :
                    PlayerCharacter[] characterArray = gson.fromJson(jsonTextFromFile.toString(), PlayerCharacter[].class);
                    break;
            }

        }
        catch (IOException IOE){
            IOE.printStackTrace();
        }
        catch (NullPointerException NPE){
            System.out.println("A path to the file containing this object does not exist");
        }
        return characterList;

    }

     */
}

