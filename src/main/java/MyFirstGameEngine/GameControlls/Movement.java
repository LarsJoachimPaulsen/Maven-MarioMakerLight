package MyFirstGameEngine.GameControlls;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public abstract class Movement {

    private static int characterMovementSpeed = 10;

    public static void addMovement(ImageView playableCharacterSprite){

        playableCharacterSprite.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Scene scene = playableCharacterSprite.getScene();
                switch (keyEvent.getCode()) {
                    case D:
                        if(playableCharacterSprite.getX() > scene.getWidth()){
                            playableCharacterSprite.setX(0);
                        }
                        else {
                            playableCharacterSprite.setX(playableCharacterSprite.getX() + characterMovementSpeed);
                        }
                        //checkCollision(1);
                        keyEvent.consume();
                        break;
                    case A:
                        if (playableCharacterSprite.getX() < 0){
                            playableCharacterSprite.setX(scene.getWidth());
                        }
                        else {
                            playableCharacterSprite.setX(playableCharacterSprite.getX() - characterMovementSpeed);
                        }
                        keyEvent.consume();
                        //checkCollision(2);
                        break;
                    case W:
                        if (playableCharacterSprite.getY() < -(scene.getHeight())){
                            playableCharacterSprite.setY(scene.getHeight());
                        }
                        else if (playableCharacterSprite.getY() < -260) {
                            return;
                        }
                        else {
                            playableCharacterSprite.setY(playableCharacterSprite.getY() - characterMovementSpeed);
                        }

                        keyEvent.consume();
                      //  checkCollision(3);
                        break;
                    case S:
                        if (playableCharacterSprite.getY() > scene.getHeight()){
                            playableCharacterSprite.setY(0);
                        }
                        else if (playableCharacterSprite.getY() > 665) {
                            return;
                        }
                        else {
                            playableCharacterSprite.setY(playableCharacterSprite.getY() + characterMovementSpeed);
                        }
                        keyEvent.consume();
                      //  checkCollision(4);
                        break;
                }
            }
        });
    }

}
