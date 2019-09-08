package InterfazGrafica;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;


public class Circular extends Circle {

    private double orgSceneX,orgSceneY;
    private double orgTranslateX,orgTranslateY;

    public Circular(double X,double Y) {
        super(X,Y,5,Color.BLACK);
    }


    public void Pressed (MouseEvent t){

        orgSceneX = t.getSceneX();
        orgSceneY = t.getSceneY();
        orgTranslateX = ((Shape)(t.getSource())).getTranslateX();
        orgTranslateY = ((Shape)(t.getSource())).getTranslateY();

    }

    public void Dragged(MouseEvent t){
        double offsetX = t.getSceneX() - orgSceneX;
        double offsetY = t.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        this.setTranslateX(newTranslateX);
        this.setTranslateY(newTranslateY);

    }

}