package Gruppe18.FileHandeling;

import Gruppe18.Data.Car;
import Gruppe18.Data.Enemy;
import Gruppe18.Data.PlayerCharacter;
import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Writer_Reader {

    private static ArrayList<PlayerCharacter> playableCharacters = new ArrayList<>();
    private static ArrayList<Enemy> enemyCharacters = new ArrayList<>();
    private static ArrayList<Car> carCharacters = new ArrayList<>();


    //This method will write a character to the correct file, if it does not already exist.

    /**
     * A method for writing a character to a json-file
     * @param character takes a character object and converts it to the correct json-file
     */
    public static void writeCharacterToFile(Object character) {

        boolean characterExists = false;
        File file = null;
        if (character instanceof PlayerCharacter) {

            file = new File("src/main/resources/Files/PlayableCharacter.json");
            if (file.length() != 0) {
                playableCharacters = getPlayableCharacters();
            }
            for (int i = 0; i < playableCharacters.size(); i++) {
                if (playableCharacters.get(i).getName().equals(((PlayerCharacter) character).getName())) {
                    characterExists = true;
                    break;
                }
            }
            if (characterExists) {
                System.out.println("Character exist");
                return;
            } else {
                playableCharacters.add((PlayerCharacter) character);
            }
            // legg til character i Array.
            // skriv hele array.

        } else if (character instanceof Enemy) {

            file = new File("src/main/resources/Files/Enemy.json");
            if(file.length() != 0) {
                enemyCharacters = getEnemyCharacters();
            }
            for (int i = 0; i < enemyCharacters.size(); i++) {
                if (enemyCharacters.get(i).getName().equals(((Enemy) character).getName())) {
                    characterExists = true;
                    break;
                }
            }

            if (characterExists) {
                System.out.println("Character already exists");
                return;
            } else {
                enemyCharacters.add((Enemy) character);
            }

        } else if (character instanceof Car) {

            file = new File("src/main/resources/Files/Car.json");

            if(file.length() != 0) {
                carCharacters = getCarCharacters();
            }
            for (int i = 0; i < carCharacters.size(); i++) {
                if (carCharacters.get(i).getName().equals(((Car) character).getName())) {
                    characterExists = true;
                    break;
                }
            }

            if (characterExists) {
                System.out.println("The Character already exist");
                return;
            } else {
                carCharacters.add((Car) character);
            }


        }

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        String jsonWriter = "";

        if (character instanceof PlayerCharacter) {
            jsonWriter = gson.toJson(playableCharacters);
        } else if (character instanceof Enemy) {
            jsonWriter = gson.toJson(enemyCharacters);
        } else if (character instanceof Car) {
            jsonWriter = gson.toJson(carCharacters);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(jsonWriter);
        } catch (IOException IOE) {
            IOE.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("A path to the file containing this object does not exist");
        }

    }

    /**
     *  A method to get all Car object saved to a file
     * @return returns an ArrayList of Car objects
     */
    public static ArrayList<Car> getCarCharacters() {
            File file = new File("src/main/resources/Files/Car.json");

            GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

            Gson gson = gsonBuilder.create();

            ArrayList<Car> cars = new ArrayList<>();

            String line = "";

            StringBuilder jsonTextFromFile = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                while ((line = br.readLine()) != null) {
                    jsonTextFromFile.append(line);
                }

                Car[] arrayCar = gson.fromJson(jsonTextFromFile.toString(), Car[].class);

                cars.addAll(Arrays.asList(arrayCar));

                return cars;
            } catch (IOException IOE) {
                IOE.printStackTrace();
                return null;
            }
        }


    /**
     *  A method to get all the enemy objects saved to file
     * @return an ArrayList of Enemy objects
     */
    public static ArrayList<Enemy> getEnemyCharacters() {

            File file = new File("src/main/resources/Files/Enemy.json");

            GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

            Gson gson = gsonBuilder.create();

            ArrayList<Enemy> enemies = new ArrayList<>();

            String line = "";

            StringBuilder jsonTextFromFile = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                while ((line = br.readLine()) != null) {
                    jsonTextFromFile.append(line);
                }

                Enemy[] enemyList = gson.fromJson(jsonTextFromFile.toString(), Enemy[].class);

                enemies.addAll(Arrays.asList(enemyList));

                return enemies;
            } catch (IOException IOE) {
                IOE.printStackTrace();
                return null;
            }
        }


    /**
     * A method to get all PlayerCharacter objects saved to file
     * @return an ArrayList of PlayerCharacter objects.
     */
    public static ArrayList<PlayerCharacter> getPlayableCharacters() {


            File file = new File("src/main/resources/Files/PlayableCharacter.json");


            GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
            Gson gson = gsonBuilder.create();

            ArrayList<PlayerCharacter> playerArray = new ArrayList<>();

            String line = "";

            StringBuilder jsonTextFromFile = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                while ((line = br.readLine()) != null) {
                    jsonTextFromFile.append(line);
                }
                PlayerCharacter[] playerList = gson.fromJson(jsonTextFromFile.toString(), PlayerCharacter[].class);

                playerArray.addAll(Arrays.asList(playerList));

                return playerArray;

            } catch (IOException IOE) {
                IOE.printStackTrace();

                return null;
            }

        }

    /**
     *  A method to print all the Classes method to console, with a short description.
     */
    public void help(){
            // må implementeres
        }

    /**
     *  A method to print the information of the method given.
      * @param methodName The name of the method you want more information about.
     */
    public void help(String methodName){
        // må implementeres
    }

}

