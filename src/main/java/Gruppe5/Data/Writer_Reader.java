package Gruppe5.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;


public class Writer_Reader {

    //This method will write a character to the correct file, if it does not already exist.
    public void writeCharacterToFil(Object character){

        File file = null;



            if (character instanceof PlayerCharacter){
                file = new File("src/main/resources/Files/PlayableCharacter.json");
            }
            else if(character instanceof Enemy){
                file = new File("src/main/resources/Files/Enemy.json");
            }
            else if(character instanceof Car){
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

