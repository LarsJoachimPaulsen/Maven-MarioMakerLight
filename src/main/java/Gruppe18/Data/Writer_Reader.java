package Gruppe18.Data;

import com.google.gson.*;
import com.google.gson.internal.Streams;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Writer_Reader {

    private ArrayList<PlayerCharacter> playableCharacters = new ArrayList<>();
    private ArrayList<Enemy> enemyCharacters = new ArrayList<>();
    private ArrayList<Car> carCharacters = new ArrayList<>();


    //This method will write a character to the correct file, if it does not already exist.

    public void writeCharacterToFil(Object character){

        boolean characterExists = false;
        File file = null;
            if (character instanceof PlayerCharacter ){

                playableCharacters = getPlayableCharacters();
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
                else {
                    playableCharacters.add((PlayerCharacter) character);
                }


                // legg til character i Array.
                // skriv hele array.
                file = new File("src/main/resources/Files/PlayableCharacter.json");
            }
            else if(character instanceof  Enemy){

                enemyCharacters = getEnemyCharacters();
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
                else {
                    enemyCharacters.add((Enemy)character);
                }

                file = new File("src/main/resources/Files/Enemy.json");
            }
            else if(character instanceof Car){

                carCharacters = getCarCharacters();
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
                else {
                    carCharacters.add((Car)character);
                }

                file = new File("src/main/resources/Files/Car.json");
            }

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        String jsonWriter = "";

        if (character instanceof PlayerCharacter){
            jsonWriter = gson.toJson(playableCharacters);
        }
        else if(character instanceof  Enemy){
            jsonWriter = gson.toJson(enemyCharacters);
        }
        else if(character instanceof Car){
            jsonWriter = gson.toJson(carCharacters);
        }

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


    public ArrayList<Car> getCarCharacters() {
    }

    public ArrayList<Enemy> getEnemyCharacters() {
    }


    public ArrayList<PlayerCharacter> getPlayableCharacters() {


        File file = new File("src/main/resources/Files/PlayableCharacter.json");

        String filepath = "src/main/resources/Files/PlayableCharacter.json";




        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        ArrayList<PlayerCharacter> playerArray= new ArrayList<>();

        String line = "";

        StringBuilder jsonTextFromFile = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                jsonTextFromFile.append(line);
            }

            System.out.println(jsonTextFromFile.toString());

            PlayerCharacter[] playerList = gson.fromJson(jsonTextFromFile.toString(), PlayerCharacter[].class);

           playerArray.addAll(Arrays.asList(playerList));

            return playerArray;

        } catch (IOException IOE) {
            IOE.printStackTrace();

            return null;
        }

    }

}

