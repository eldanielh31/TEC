package InterfazGrafica;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Clase heredada de rectangulo que funciona como estadia de la imagen en el pane central.
 */
public class Rectangular extends Rectangle {
    private double orgSceneX,orgSceneY;
    private double orgTranslateX,orgTranslateY;
    private Circular Output, OutputII,Input;
    private Label ID;

    /**
     * Constructor de la clase que define los atributos y algunos eventos.
     * @param width - ancho
     * @param height - largo
     * @param image - imagen
     * @param e - evento
     * @param output - input
     * @param outputII - input 2
     * @param input - output
     * @param label - label con ID
     */
    public Rectangular(int width, int height, ImageView image, DragEvent e,Circular output, Circular outputII, Circular input, Label label) {
        super(width,height);
        this.Output=output;
        this.OutputII=outputII;
        this.Input=input;
        this.setFill(new ImagePattern(image.getImage()));
        this.setCursor(Cursor.MOVE);
        this.setX(e.getSceneX());
        this.setY(e.getSceneY());
        this.ID=label;
        this.ID.setLayoutX(e.getSceneX()+40);
        this.ID.setLayoutY(e.getSceneY());

        this.setOnMousePressed(RectangleOnMousePressedEventHandler);
        this.setOnMouseDragged(RectangleOnMouseDraggedEventHandler);
    }


    /**
     * Evento al precionar el rectangulo con la imagen.
     */
    private EventHandler<MouseEvent> RectangleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
                    if (OutputII!=null) {
                        Output.Pressed(t);
                        OutputII.Pressed(t);
                        Input.Pressed(t);
                    }
                    else{
                        Output.Pressed(t);
                        Input.Pressed(t);
                    }
                }
            };
    /**
     * Evento al mover el rectangulo con la imagen.
     */
    private EventHandler<MouseEvent> RectangleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    ((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
                    ID.setTranslateX(newTranslateX);
                    ID.setTranslateY(newTranslateY);
                    if (OutputII!=null) {
                        Output.Dragged(t);
                        OutputII.Dragged(t);
                        Input.Dragged(t);
                    }
                    else {
                        Output.Dragged(t);
                        Input.Dragged(t);
                    }
                }
            };
}