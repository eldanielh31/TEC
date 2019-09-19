package InterfazGrafica;

import com.sun.tools.javadoc.Start;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Circular extends Circle{
    private static boolean Draw;
    private static double StartX, StartY;
    private Line line;
    private boolean HaveLine;
    //Variables para mover el circulo
    private double orgSceneX,orgSceneY;
    private double orgTranslateX,orgTranslateY;

    public Circular(double X,double Y) {
        super(X, Y, 5, Color.BLACK);
        Draw=false;
        HaveLine=false;

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Click(e);
            }
        });
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

    public void Click(MouseEvent e){
        if(HaveLine==false){
            if (Draw) {
                line = new Line(StartX, StartY, e.getSceneX(), e.getSceneY());
                this.setFill(Color.GREEN);
                RootMain.Group.getChildren().add(line);
                Draw=false;
                HaveLine = true;
            } else {
                StartX = e.getSceneX();
                StartY = e.getSceneY();
                Draw = true;
                HaveLine=true;
                this.setFill(Color.RED);
            }
        }
    }


    public Line getLine() {
        return line;
    }
}
