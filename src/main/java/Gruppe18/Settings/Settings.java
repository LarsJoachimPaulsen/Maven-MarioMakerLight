package Gruppe18.Settings;

import Gruppe18.Controller.MainController;
import javafx.scene.control.ListView;
import javafx.stage.Screen;

public abstract class Settings {

    public static String currentOrientationOfToolBar = "";
    private static double screenHeigth = Screen.getPrimary().getBounds().getHeight();
    private static double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static double mainToolbarWidth = 0;
    private static double mainToolbarHeigth = 0;

    /**
     * A method to change the direction of the main toolbar
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

/*
    public void setOrientationOfToolBar(String orientation){

        boolean trigger = false;
        switch (orientation.toLowerCase()){

            case "left" :
                toolSelect.setMinHeight(screenHeigth);
                toolSelect.setMinWidth(screenWidth*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "l";
                trigger = true;
                break;

            case "right" :
                toolSelect.setMinHeight(screenHeigth);
                toolSelect.setMinWidth(screenWidth*.05);
                toolSelect.setLayoutX(screenWidth-125);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "r";
                trigger = true;
                break;

            case "top" :
                toolSelect.setMinWidth(screenWidth);
                toolSelect.setMinHeight(screenHeigth*.05);
                toolSelect.setMaxHeight(screenHeigth*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(0);
                currentOrientationOfToolBar = "t";
                trigger = true;
                break;

            case "bottom" :
                toolSelect.setMinWidth(screenWidth);
                toolSelect.setMinHeight(screenHeigth*.05);
                toolSelect.setMaxHeight(screenHeigth*.05);
                toolSelect.setLayoutX(0);
                toolSelect.setLayoutY(screenHeigth-125);
                currentOrientationOfToolBar = "b";
                trigger = true;
                break;

        }
        if(!trigger){
            System.out.println("Error in setOnOrientationOfToolbar!! String value needs to be top, bottom, left or right");
        }

    }

    // skal flyttes til innstillinger
    public void setOriontationOfSecondaryToolBar(String oriantation) {

        boolean trigger = false;

        switch (oriantation.toLowerCase()){
            case "left" :
                if (currentOrientationOfToolBar.toLowerCase().equals("l")){

                    underObjectToolSelect.setLayoutX(toolSelect.getMinWidth());
                    toolSelectedLabel.setLayoutX(toolSelect.getMinWidth()*2);
                }
                else{
                    underObjectToolSelect.setLayoutX(0);

                }
                underObjectToolSelect.setLayoutY(0);
                underObjectToolSelect.setMinHeight(screenHeigth);
                underObjectToolSelect.setMaxWidth(screenWidth*0.05);
                trigger = true;
                break;

            case "right" :
                if (currentOrientationOfToolBar.toLowerCase().equals("r")){
                    underObjectToolSelect.setLayoutX(screenWidth - screenWidth*.1);
                }
                else {
                    underObjectToolSelect.setLayoutX(screenWidth-125);

                }
                underObjectToolSelect.setLayoutY(0);
                underObjectToolSelect.setMinHeight(screenHeigth);
                underObjectToolSelect.setMaxWidth(screenWidth*.05);
                trigger = true;
                break;

            case "top" :
                if (currentOrientationOfToolBar.toLowerCase().equals("t")){
                    underObjectToolSelect.setLayoutY(toolSelect.getMaxHeight());
                    System.out.println(toolSelect.getMaxHeight());
                }
                else {
                    underObjectToolSelect.setLayoutY(0);
                }
                underObjectToolSelect.setLayoutX(0);
                underObjectToolSelect.setMinWidth(screenWidth);
                underObjectToolSelect.setMaxHeight(screenHeigth*.05);
                trigger = true;
                break;

            case "bottom" :
                if (currentOrientationOfToolBar.toLowerCase().equals("b")){
                    underObjectToolSelect.setLayoutY(screenHeigth-125 - toolSelect.getMaxHeight());
                }
                else {
                    underObjectToolSelect.setLayoutY(screenHeigth-125);
                }
                underObjectToolSelect.setLayoutX(0);
                underObjectToolSelect.setMinWidth(screenWidth);
                underObjectToolSelect.setMaxHeight(screenHeigth*.05);
                trigger = true;
                break;
        }

        if(!trigger){
            System.out.println("Error in setOrientationOfSecondaryToolbar! String value needs to be left, right, top or bottom");
        }
    }
*/

    public void help(){
        // method a user can call to get help with the class in question. Will be printed in console

    }

}
