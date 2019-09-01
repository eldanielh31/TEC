package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Eventos {

    private static Rectangle rectangle;
    private static Circle circle;
    static double orgSceneX,orgSceneY;
    static double orgTranslateX,orgTranslateY;

   public static final void DragDetected(MouseEvent e, ImageView Comp, String Name){
        Dragboard db= Comp.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content=new ClipboardContent();
        content.putString(Name);
        db.setContent(content);
        e.consume();
    }

    private static void DroppedAux(DragEvent e,ImageView i){
       rectangle=new Rectangle(50,50);

       circle=new Circle(50, Color.GREEN);
       circle.setCursor(Cursor.MOVE);
       circle.setCenterX(e.getSceneX());
       circle.setCenterY(e.getSceneY());
       circle.setOnMousePressed(circleOnMousePressedEventHandler);
       circle.setOnMouseDragged(circleOnMouseDraggedEventHandler);

       RootMain.Group.getChildren().add(circle);
       RootMain.Group.getChildren().add(rectangle);
    }

    public static final void Dropped(DragEvent e){
        System.out.println(e.getDragboard().getString());
        if (e.getDragboard().getString().equals(AND.Name)) {
            Eventos.DroppedAux(e,RootMain.and.getImage()); }
        if (e.getDragboard().getString().equals(NAND.Name)){
            Eventos.DroppedAux(e,RootMain.nand.getImage()); }
        if (e.getDragboard().getString().equals(OR.Name)){
            Eventos.DroppedAux(e,RootMain.or.getImage()); }
        if (e.getDragboard().getString().equals(XOR.Name)){
            Eventos.DroppedAux(e,RootMain.xor.getImage()); }
        if (e.getDragboard().getString().equals(NOR.Name)){
            Eventos.DroppedAux(e,RootMain.nor.getImage()); }
        if (e.getDragboard().getString().equals(XNOR.Name)){
            Eventos.DroppedAux(e,RootMain.xnor.getImage()); }

        System.out.println("Dropped");
        System.out.println(e.getSceneX());
        System.out.println(e.getSceneY());
    }


    static EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
                }
            };

    static EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Circle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };


}


