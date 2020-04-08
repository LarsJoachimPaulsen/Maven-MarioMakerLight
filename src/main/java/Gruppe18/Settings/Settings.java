package Gruppe18.Settings;

import Gruppe18.Controller.MainController;
import javafx.scene.control.ListView;
import javafx.stage.Screen;

public abstract class Settings {

    private static String currentOrientationOfToolBar = "";
    private static double screenHeigth = Screen.getPrimary().getBounds().getHeight();
    private static double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static double mainToolbarWidth = 0;
    private static double mainToolbarHeigth = 0;
    private static String backgroundFilePath = "Pictures/Backgrounds/defaultBackgrond.png";


    public void addNewBackground(String localFilepath) {
        //will add user defined pictures in the background folder
    }

    public void setProrgramIcon(String pathToIcon){
        // will set the programs icon
    }

    // disse metodene bør endres, så det ikke har noe å si hvilken som blir kalt først.
    /**
     * A method to change the direction of the main toolbar. If both toolbars are to be changed,
     * this method should be called first!
     * @param list the listview you want to change
     * @param orientation right, left, up or bottom.
     */
    public static void setOrientationOfToolBar(ListView list, String orientation){

        boolean trigger = false;
        switch (orientation.toLowerCase()){

            case "left" :
                list.setMinHeight(screenHeigth);
                list.setMinWidth(screenWidth*.05);
                list.setLayoutX(0);
                list.setLayoutY(0);
                currentOrientationOfToolBar = "l";
                mainToolbarWidth = screenWidth*.5;

                trigger = true;
                break;

            case "right" :
                list.setMinHeight(screenHeigth);
                list.setMinWidth(screenWidth*.05);
                list.setLayoutX(screenWidth-125);
                list.setLayoutY(0);
                mainToolbarWidth = screenWidth*.05;
                currentOrientationOfToolBar = "r";
                trigger = true;
                break;

            case "top" :
                list.setMinWidth(screenWidth);
                list.setMinHeight(screenHeigth*.05);
                list.setMaxHeight(screenHeigth*.05);
                list.setLayoutX(0);
                list.setLayoutY(0);
                currentOrientationOfToolBar = "t";
                mainToolbarHeigth = screenHeigth*.05;
                trigger = true;
                break;

            case "bottom" :
                list.setMinWidth(screenWidth);
                list.setMinHeight(screenHeigth*.05);
                list.setMaxHeight(screenHeigth*.05);
                list.setLayoutX(0);
                list.setLayoutY(screenHeigth-125);
                mainToolbarHeigth = screenHeigth*.05;
                currentOrientationOfToolBar = "b";
                trigger = true;
                break;

        }
        if(!trigger){
            System.out.println("Error in setOnOrientationOfToolbar!! String value needs to be top, bottom, left or right");
        }

    }

    // bugs

    /**
     * A method that sets the orientation of the secondary toolbar. The position of the toolbar will change based on
     * the position of the secondary toolbar. Are both toolbars to be changed, this method should be called last!
     * @param list The toolbar to
     * @param oriantation
     */
    public static void setOriontationOfSecondaryToolBar(ListView list, String oriantation) {

        boolean trigger = false;

        switch (oriantation.toLowerCase()){
            case "left" :
                if (currentOrientationOfToolBar.toLowerCase().equals("l")){

                    list.setLayoutX(mainToolbarWidth);
                    //toolSelectedLabel.setLayoutX(toolSelect.getMinWidth()*2);
                }
                else{
                    list.setLayoutX(0);

                }
                list.setLayoutY(0);
                list.setMinHeight(screenHeigth);
                list.setMaxWidth(screenWidth*0.05);
                trigger = true;
                break;

            case "right" :
                if (currentOrientationOfToolBar.toLowerCase().equals("r")){
                    list.setLayoutX(screenWidth - screenWidth*.1);
                }
                else {
                    list.setLayoutX(screenWidth-125);

                }
                list.setLayoutY(0);
                list.setMinHeight(screenHeigth);
                list.setMaxWidth(screenWidth*.05);
                trigger = true;
                break;

            case "top" :
                if (currentOrientationOfToolBar.toLowerCase().equals("t")){
                    list.setLayoutY(screenHeigth);
                    //System.out.println(toolSelect.getMaxHeight());
                }
                else {
                    list.setLayoutY(0);
                }
                list.setLayoutX(0);
                list.setMinWidth(screenWidth);
                list.setMaxHeight(screenHeigth*.05);
                trigger = true;
                break;

            case "bottom" :
                if (currentOrientationOfToolBar.toLowerCase().equals("b")){
                    list.setLayoutY(screenHeigth-125 - mainToolbarHeigth);
                }
                else {
                    list.setLayoutY(screenHeigth-125);
                }
                list.setLayoutX(0);
                list.setMinWidth(screenWidth);
                list.setMaxHeight(screenHeigth*.05);
                trigger = true;
                break;
        }

        if(!trigger){
            System.out.println("Error in setOrientationOfSecondaryToolbar! String value needs to be left, right, top or bottom");
        }
    }


    /**
     * This method prints information about all the methods in the Settings class.
     * The information will be printed to console
     */
    public static void help(){
        // method a user can call to get help with the class in question. Will be printed in console

    }

    /**
     * This method prints information about the given method from the settings class.
     * The information will be printed to console.
     * @param nameOfMethod The name of the method the user needs information on
     */
    public static void help(String nameOfMethod){

    }

}
