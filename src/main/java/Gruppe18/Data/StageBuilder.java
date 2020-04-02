package Gruppe18.Data;

public class StageBuilder {

    Stage stage = new Stage();

    public StageBuilder stageWidth(int stageWidth){
        stage.stageWidth = stageWidth;
        return this;
    }

    public StageBuilder stageHeight(int stageHeight){
        stage.stageHeight = stageHeight;
        return this;
    }
}
