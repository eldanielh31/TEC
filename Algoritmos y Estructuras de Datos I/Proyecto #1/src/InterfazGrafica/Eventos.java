package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Eventos {

    private static Rectangle rectangle;
    private static Circle circle;
    private static double orgSceneX,orgSceneY;
    private static double orgTranslateX,orgTranslateY;

   public static final void DragDetected(MouseEvent e, ImageView Comp, String Name){
        Dragboard db= Comp.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content=new ClipboardContent();
        content.putString(Name);
        db.setContent(content);
        e.consume();
    }

    private static void DroppedAux(DragEvent e,ImageView i){
       rectangle=new Rectangle(50,50);
       rectangle.setFill(new ImagePattern(i.getImage()));
       rectangle.setCursor(Cursor.MOVE);
       rectangle.setX(e.getSceneX());
       rectangle.setY(e.getSceneY());
       rectangle.setOnMousePressed(RectangleOnMousePressedEventHandler);
       rectangle.setOnMouseDragged(RectangleOnMouseDraggedEventHandler);

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

    private static EventHandler<MouseEvent> RectangleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
                }
            };

    private static EventHandler<MouseEvent> RectangleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };
}


