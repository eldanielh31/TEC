package InterfazGrafica;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Esta clase funciona como un refactor de eventos.
 */
public class Eventos {

    private static Circular output, outputII, input;
    private static Rectangle rectangle;
    private static double orgSceneX,orgSceneY;
    private static double orgTranslateX,orgTranslateY;

    /**
     * Este metodo gestiona el drag de la imagen
     * que se encuentra en la paleta.
     * @param e - Evento de mouse al mover la imagen.
     * @param Comp - Imagen del componente.
     * @param Name - Nombre del componente que se está moviendo.
     */
   public static final void DragDetected(MouseEvent e, ImageView Comp, String Name){
        Dragboard db= Comp.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content=new ClipboardContent();
        content.putString(Name);
        db.setContent(content);
        e.consume();
    }

    /**
     * Este metodo es un auxiliar del evento drop de la imagen.
     * En este se coloca la imagen en un rectangulo para la
     * implementacion en el pane principal.
     * @param e - Evento tipo drag.
     * @param i - Imagen del componente.
     */
    private static void DroppedAux(DragEvent e,ImageView i){
        output=new Circular(e.getSceneX(), e.getSceneY()+10);
        outputII=new Circular(e.getSceneX(), e.getSceneY()+30);
        input=new Circular(e.getSceneX()+50,e.getSceneY()+20);
        rectangle=new Rectangular(50,40,i,e,output,outputII,input);
        RootMain.Group.getChildren().addAll(rectangle,output,outputII,input);
    }

    /**
     * Este metodo gestiona el drop de la imagen del componente.
     * Identifica que componente se está moviendo, imprime en un TextArea
     * e introduce en una lista enlazada cada componente.
     * @param e - Evento tipo DragEvent.
     */
    public static final void Dropped(DragEvent e, ImageView[] i){
        int cont=0;
        for (String x:RootMain.Names){
            if (e.getDragboard().getString().equals(x)){
                Eventos.DroppedAux(e,i[cont]);
                RootMain.AreaText.appendText("Agrega componente "+ x +"\n");
                if (RootMain.Lista.Tamano()==0){
                    RootMain.Lista.InsertarInicio(new FactoryPalete().ComponentFactory(x)); }
                else{
                    RootMain.Lista.InsertarFinal(new FactoryPalete().ComponentFactory(x)); }
            }
            cont++;
        }
    }
}


