package MyFirstGameEngine.FileHandeling;

import MyFirstGameEngine.CharacterCreation.Car;
import MyFirstGameEngine.CharacterCreation.Enemy;
import MyFirstGameEngine.CharacterCreation.PlayerCharacter;
import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Serializable {

    /**
     *  An ArrayList that contains all the saved PlayableCharacter objects
     */
    private static ArrayList<PlayerCharacter> playableCharacters = new ArrayList<>();

    /**
     * An ArrayList that contains all the saved Enemy objects
     */
    private static ArrayList<Enemy> enemyCharacters = new ArrayList<>();

    /**
     * An ArrayList that contains all the saved Car objects
     */
    private static ArrayList<Car> carCharacters = new ArrayList<>();

    private static Integer sizeOfHigscoreList = 10;

    //This method will write a character to the correct file, if it does not already exist.


    /**
     * A method for writing a character to a json-file
     * @param character takes a character object and converts it to the correct json-file
     * @author Lars
     */

    public static void writeCharacterToFile(Object character){

        File file = null;

        if(character instanceof PlayerCharacter){

            file = new File("src/main/resources/Files/PlayableCharacter.json");
            if (file.length() != 0){

                playableCharacters = getPlayableCharacters();

                for(PlayerCharacter playerList : playableCharacters){

                    if (playerList.getName().equals(((PlayerCharacter) character).getName())){
                        System.err.println("character already exits");
                        return;
                    }
                }
            }
            playableCharacters.add((PlayerCharacter) character);
        } else if(character instanceof Enemy){
            file = new File("src/main/resources/Files/Enemy.json");

            if (file.length() != 0){
                enemyCharacters = getEnemyCharacters();

                for(Enemy enemiesList : enemyCharacters){
                    if (enemiesList.getName().equals(((Enemy) character).getName())){
                        System.err.println("character already exists");
                        return;
                    }
                }
            }
            enemyCharacters.add((Enemy) character);
        } else if (character instanceof Car){

            file = new File("src/main/resources/Files/Car.json");

            if (file.length() != 0){
                carCharacters = getCarCharacters();

                for (Car carsList: carCharacters){
                    if (carsList.getName().equals(((Car) character).getName())){
                        System.err.println("character already exists");
                        return;
                    }
                }
            }
            carCharacters.add((Car) character);

        }

        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.create();

        String jsonWriter = "";

        if (character instanceof PlayerCharacter){
            jsonWriter = gson.toJson(playableCharacters);
        } else if(character instanceof  Enemy){
            jsonWriter = gson.toJson(enemyCharacters);
        } else if(character instanceof Car){
            jsonWriter = gson.toJson(carCharacters);
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(jsonWriter);
        }catch (IOException IOE){
            IOE.printStackTrace();
        }catch (NullPointerException NPE){
            System.out.println("File error");
        }

    }




    /**
     * A method for writing an array of highscores to a json-file
     * @param listOfHigscores a list of Integer values
     * @author Lars
     */
    public static void writeHighScore(Integer[] listOfHigscores){
        File file = new File("src/main/resources/Files/HighScore.json");

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        String jsonWriter = "";

        jsonWriter = gson.toJson(listOfHigscores);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(jsonWriter);
        }catch (IOException IOE){
            IOE.printStackTrace();
        }
    }

    /**
     * A method to get all highscores from file.
     * @return an array of Integers
     */
    public static Integer[] getHighscoreList(){
        File file = new File("src/main/resources/Files/HighScore.json");

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        Integer[] highscoreList;

        String line = "";

        StringBuilder jsonTextFromFile = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while((line = br.readLine()) != null){
                jsonTextFromFile.append(line);
            }

            highscoreList = gson.fromJson(jsonTextFromFile.toString(), Integer[].class);

            return highscoreList;
        }catch (IOException IOE){
            IOE.printStackTrace();
            return null;
        }
    }

    /**
     *  A method to get all Car object saved to a file
     * @return returns an ArrayList of Car objects
     * @author Lars
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
     * @author Lars
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
     * @author Lars
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
        System.out.println("her kommer hjelp");
        }

    /**
     *  A method to print the information of the method given.
      * @param methodName The name of the method you want more information about.
     */
    public void help(String methodName){
        System.out.println("her kommer mer hjelo");
    }

    public static Integer getSizeOfHigscoreList(){
        return sizeOfHigscoreList;
    }

}

