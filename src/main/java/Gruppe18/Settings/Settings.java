package Gruppe18.Settings;

import Gruppe18.Controller.MainController;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.stage.Screen;



// MÅ SKRIVES OM OG FLYTTES UT TIL CONTROLLER.

public abstract class Settings {

    private static String currentOrientationOfToolBar = "";
    private static double screenHeigth = Screen.getPrimary().getBounds().getHeight();
    private static double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static double mainToolbarWidth = 0;
    private static double mainToolbarHeigth = 0;

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
     * @author Lars
     */
    public static void setOrientationOfToolBar(ListView list, String orientation){

        switch (orientation.toLowerCase()){



            case "left" :
                list.setMinHeight(screenHeigth);
                list.setMinWidth(screenWidth*.05);
                list.setLayoutX(0);
                list.setLayoutY(0);
                list.setOrientation(Orientation.VERTICAL);
                currentOrientationOfToolBar = "l";
                mainToolbarWidth = screenWidth*.5;
                break;

            case "right" :
                list.setMinHeight(screenHeigth);
                list.setMinWidth(screenWidth*.05);
                list.setLayoutX(screenWidth-125);
                list.setLayoutY(0);
                list.setOrientation(Orientation.VERTICAL);
                mainToolbarWidth = screenWidth*.05;
                currentOrientationOfToolBar = "r";
                break;

            case "top" :
                list.setMinWidth(screenWidth);
                list.setMinHeight(screenHeigth*.05);
                list.setMaxHeight(screenHeigth*.05);
                list.setLayoutX(0);
                list.setLayoutY(0);
                list.setOrientation(Orientation.HORIZONTAL);
                currentOrientationOfToolBar = "t";
                mainToolbarHeigth = screenHeigth*.05;
                break;

            case "bottom" :
                list.setMinWidth(screenWidth);
                list.setMinHeight(screenHeigth*.05);
                list.setMaxHeight(screenHeigth*.05);
                list.setLayoutX(0);
                list.setLayoutY(screenHeigth-125);
                list.setOrientation(Orientation.HORIZONTAL);
                mainToolbarHeigth = screenHeigth*.05;
                currentOrientationOfToolBar = "b";
                break;

            default :
                System.out.println("Error in setOnOrientationOfToolbar!! String value needs to be top, bottom, left or right");
                break;
        }

    }

    // bugs

    /**
     * A method that sets the orientation of the secondary toolbar. The position of the toolbar will change based on
     * the position of the secondary toolbar. Are both toolbars to be changed, this method should be called last!
     * @param list The toolbar to
     * @param oriantation the orientation of the toolbar, accepts right, left, up, or bottom.
     * @author Lars
     */
    public static void setOrientationOfSecondaryToolBar(ListView list, String oriantation) {


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
                list.setOrientation(Orientation.VERTICAL);
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
                list.setOrientation(Orientation.VERTICAL);
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
                list.setOrientation(Orientation.HORIZONTAL);
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
                list.setOrientation(Orientation.HORIZONTAL);
                break;

            default :
                System.out.println("Error in setOrientationOfSecondaryToolbar! String value needs to be left, right, top or bottom");
                break;
        }
    }


    /**
     * This method prints information about all the methods in the Settings class.
     * The information will be printed to console
     */
    public static void help(){

        System.out.println();
        System.out.println("Add new Background");
        System.out.println("This method allows for adding new backgrounds to the background file of the framewordk");
        System.out.println("\n");

        System.out.println("Set programIcon");
        System.out.println("This method allows for adding new program icons for the JavaFX program");
        System.out.println("\n");

        System.out.println("Set orientation orientation of toolbar");
        System.out.println("This method allows the user to change the layout of the main toolbar \n" +
                "It can be moved by using \"top\", \"buttom\", \"left\" or \"right\" ");
        System.out.println("\n");
        // method a user can call to get help with the class in question. Will be printed in console

        System.out.println("Set orientation of of secondary toolbar");
        System.out.println("This method allows the user to change the layout of the secondary toolbar \n" +
                "It can be moved by using \"top\", \"buttom\", \"left\" or \"right\" ");
    }

    /**
     * This method prints information about the given method from the settings class.
     * The information will be printed to console.
     * @param nameOfMethod The name of the method the user needs information on
     */
    public static void help(String nameOfMethod){


        switch (nameOfMethod.toLowerCase()){

            case "addnewbackground" :
                System.out.println();
                System.out.println("Add new Background");
                System.out.println("This method allows for adding new backgrounds to the background file of the framewordk");
                System.out.println();
                break;

            case "setprogramicon" :
                System.out.println();
                System.out.println("Set programIcon");
                System.out.println("This method allows for adding new program icons for the JavaFX program");
                System.out.println();
                break;

            case "setorientationoftoolbar" :
                System.out.println();
                System.out.println("Set orientation orientation of toolbar");
                System.out.println("This method allows the user to change the layout of the main toolbar \n" +
                        "It can be moved by using \"top\", \"buttom\", \"left\" or \"right\" ");
                System.out.println();
                break;

            case "setorientationofsecondarytoolbar" :
                System.out.println();
                System.out.println("Set orientation of of secondary toolbar");
                System.out.println("This method allows the user to change the layout of the secondary toolbar \n" +
                        "It can be moved by using \"top\", \"buttom\", \"left\" or \"right\" ");
                break;

            case "help" :
                System.out.println();
                System.out.println("Help");
                System.out.println("This method will print information about all, or the selected, method");
                System.out.println();
                break;

            default :
                System.out.println();
                System.out.println("This method does not exist");
                System.out.println();
                break;
        }

    }

}
