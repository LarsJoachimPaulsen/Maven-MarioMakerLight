package MyFIrstGameEngine.Data;

import java.util.ArrayList;

/**
 * @author Christine
 */
public class Background {

    private String backgroundFilePath = "Pictures/Backgrounds/defaultBackgrond.png";
    private ArrayList<Background> backgroundList = new ArrayList<>();

    public String getBackground() {
        return backgroundFilePath;
    }

}
