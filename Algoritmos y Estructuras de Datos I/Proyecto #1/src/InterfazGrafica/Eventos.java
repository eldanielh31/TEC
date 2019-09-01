package InterfazGrafica;

import ComponentesLogicos.*;
import Lista.ListaEnlazada;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.Optional;

public class Eventos {
    
    private static Rectangle rectangle;
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
       rectangle=new Rectangle(50,40);
       rectangle.setFill(new ImagePattern(i.getImage()));
       rectangle.setCursor(Cursor.MOVE);
       rectangle.setX(e.getSceneX());
       rectangle.setY(e.getSceneY());
       rectangle.setOnMousePressed(RectangleOnMousePressedEventHandler);
       rectangle.setOnMouseDragged(RectangleOnMouseDraggedEventHandler);

       RootMain.Group.getChildren().add(rectangle);
    }

    public static final void Dropped(DragEvent e){
        if (e.getDragboard().getString().equals(AND.Name)) {
            Eventos.DroppedAux(e,RootMain.and.getImage());
            RootMain.AreaText.appendText("Agrega componente AND"+"\n");
            if (RootMain.Lista.Tamano()==0){
                RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(TypeComponent.AND)); }
            else{
                RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(TypeComponent.AND)); }}
        else if(e.getDragboard().getString().equals(NAND.Name)){
            Eventos.DroppedAux(e,RootMain.nand.getImage());
            RootMain.AreaText.appendText("Agrega componente NAND"+"\n");
            if (RootMain.Lista.Tamano()==0){
                RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(TypeComponent.NAND)); }
            else{
                RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(TypeComponent.NAND)); }}
        else if(e.getDragboard().getString().equals(OR.Name)){
            Eventos.DroppedAux(e,RootMain.or.getImage());
            RootMain.AreaText.appendText("Agrega componente OR"+"\n");
            if (RootMain.Lista.Tamano()==0){
                RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(TypeComponent.OR)); }
            else{
                RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(TypeComponent.OR)); }}
        else if (e.getDragboard().getString().equals(XOR.Name)){
            Eventos.DroppedAux(e,RootMain.xor.getImage());
            RootMain.AreaText.appendText("Agrega componente XOR"+"\n");
            if (RootMain.Lista.Tamano()==0){
                RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(TypeComponent.XOR)); }
            else{
                RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(TypeComponent.XOR)); }}
        else if (e.getDragboard().getString().equals(NOR.Name)){
            Eventos.DroppedAux(e,RootMain.nor.getImage());
            RootMain.AreaText.appendText("Agrega componente NOR"+"\n");
            if (RootMain.Lista.Tamano()==0){
                RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(TypeComponent.NOR)); }
            else{
                RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(TypeComponent.NOR)); }}
        else if (e.getDragboard().getString().equals(XNOR.Name)){
            Eventos.DroppedAux(e,RootMain.xnor.getImage());
            RootMain.AreaText.appendText("Agrega componente XNOR"+"\n");
            if (RootMain.Lista.Tamano()==0){
                RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(TypeComponent.XNOR)); }
            else{
                RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(TypeComponent.XNOR)); }}
        else if (e.getDragboard().getString().equals(NOT.Name)){
            Eventos.DroppedAux(e,RootMain.not.getImage());
            RootMain.AreaText.appendText("Agrega componente NOT"+"\n");
            if (RootMain.Lista.Tamano()==0){
                RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(TypeComponent.NOT)); }
            else{
                RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(TypeComponent.NOT)); }}
        System.out.println(RootMain.Lista.Tamano());
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


