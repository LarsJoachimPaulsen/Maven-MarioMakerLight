package MyFirstGameEngine.Settings;

import MyFirstGameEngine.Settings.ToolbarOrientation;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

;

public abstract class Settings {

    private static ToolbarOrientation orientationOfMainToolbar = ToolbarOrientation.LEFT;
    private static ToolbarOrientation orientationOfSecondaryToolbar = ToolbarOrientation.RIGHT;

    private static String filepathToIcon = "Pictures/Icons/logo.png";


    public static void setOrientationOfMainToolbar(ToolbarOrientation orientationOfToolbar){
        orientationOfMainToolbar = orientationOfToolbar;

    }

    public static void setOrientationOfSecondaryToolbar(ToolbarOrientation orientationOfToolbar){
        orientationOfSecondaryToolbar = orientationOfToolbar;
    }

    public static void setProgramIcon(String filepathToProrgramIcon){
        filepathToIcon = filepathToProrgramIcon;
    }

    public static ToolbarOrientation getOrientationOfMainToolbar(){
        return orientationOfMainToolbar;
    }

    public static ToolbarOrientation getOrientationOfSecondaryToolbar(){
        return orientationOfSecondaryToolbar;
    }

    public static String getProgramIcon() {
        return filepathToIcon;
    }
}
