package MyFirstGameEngine.GameControlls;


import MyFirstGameEngine.Settings.ToolbarOrientation;

public interface CollissionDetection {

    public boolean CollisionDetection();

    //a method that will check which direction an enemy got hit from.
    // idea is that it will return TOP, BOTTOM, LEFT, or RIGHT
    public ToolbarOrientation CheckCollisionDirection();


}
