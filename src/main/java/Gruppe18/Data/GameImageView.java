package Gruppe18.Data;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class GameImageView extends ImageView {

    private ImageView _imageView;

    public GameImageView(Pane root, String url){
        _imageView = new ImageView(url);
        _imageView.setCache(true);
        _imageView.setFocusTraversable(true);
        root.getChildren().add(_imageView);
    }

    public GameImageView(Pane root, String url, double width, double heigth){
        _imageView = new ImageView(new Image(url, width, heigth, false, true));
        _imageView.setCache(true);
        _imageView.setFocusTraversable(true);
        root.getChildren().add(_imageView);
    }

    protected ImageView get_imageView(){
        return _imageView;
    }


    public double getWidth(){
        return _imageView.getImage().getWidth();
    }

    public double getHeigth(){
        return _imageView.getImage().getHeight();
    }


    public Bounds getBounds(){
        return _imageView.getBoundsInParent();
    }





}
