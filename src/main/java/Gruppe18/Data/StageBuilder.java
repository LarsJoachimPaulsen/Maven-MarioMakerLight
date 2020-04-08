package Gruppe18.Data;

/**
 * @author Vegard
 */
public class StageBuilder {

    StageCreator stageCreator = new StageCreator();

    public StageBuilder stageWidth(int stageWidth){
        stageCreator.stageWidth = stageWidth;
        return this;
    }

    public StageBuilder stageHeight(int stageHeight){
        stageCreator.stageHeight = stageHeight;
        return this;
    }



}
