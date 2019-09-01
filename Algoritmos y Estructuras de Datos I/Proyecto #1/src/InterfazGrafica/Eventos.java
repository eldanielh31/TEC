package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;

public class Eventos {

   public static final void DragDetected(MouseEvent e, ImageView Comp, String Name){
        Dragboard db= Comp.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content=new ClipboardContent();
        content.putString(Name);
        db.setContent(content);
        e.consume();
    }

    public static final void Dropped(DragEvent e){
        System.out.println(e.getDragboard().getString());
        if (e.getDragboard().getString().equals(AND.Name)) {
            StackPane x=new StackPane(RootMain.and.getImage());
            x.setPrefSize(e.getSceneX(),e.getSceneY());
            RootMain.Centro.getChildren().add(x);
        }

        if (e.getDragboard().getString().equals(NAND.Name)){
            StackPane x=new StackPane(RootMain.nand.getImage());
            x.setPrefSize(e.getSceneX(),e.getSceneY());
            RootMain.Centro.getChildren().add(x);
        }

        if (e.getDragboard().getString().equals(OR.Name)){
            StackPane x=new StackPane(RootMain.or.getImage());
            x.setPrefSize(e.getSceneX(),e.getSceneY());
            RootMain.Centro.getChildren().add(x);
        }

        if (e.getDragboard().getString().equals(XOR.Name)){
            StackPane x=new StackPane(RootMain.xor.getImage());
            x.setPrefSize(e.getSceneX(),e.getSceneY());
            RootMain.Centro.getChildren().add(x);
        }

        if (e.getDragboard().getString().equals(NOR.Name)){
            StackPane x=new StackPane(RootMain.nor.getImage());
            x.setPrefSize(e.getSceneX(),e.getSceneY());
            RootMain.Centro.getChildren().add(x);
        }

        if (e.getDragboard().getString().equals(XNOR.Name)){
            StackPane x=new StackPane(RootMain.xnor.getImage());
            x.setPrefSize(e.getSceneX(),e.getSceneY());
            RootMain.Centro.getChildren().add(x);
        }

        System.out.println("Dropped");
        System.out.println(e.getSceneX());
        System.out.println(e.getSceneY());
    }

}


