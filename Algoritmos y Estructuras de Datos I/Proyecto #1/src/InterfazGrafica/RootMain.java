package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class RootMain extends Application {
    private VBox CompLog;

    public static void main(String [] arg){
        launch(arg);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simulador de Circuitos Logicos");

        //Creacion de los operadores disponibles en la paleta
        AND and = (AND)new FactoryPalete().ComponentFacade(TypeComponent.AND);
        final ImageView ANDI=and.getImage();

        ANDI.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Drag");
                Dragboard db=ANDI.startDragAndDrop(TransferMode.ANY);

                ClipboardContent content=new ClipboardContent();
                content.putString(AND.Name);
                db.setContent(content);
                event.consume();
            }
        });

        ANDI.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("Dropped");
            }
        });


        NAND nand= (NAND)new FactoryPalete().ComponentFacade(TypeComponent.NAND);
        final ImageView NANDI=nand.getImage();

        OR or= (OR) new FactoryPalete().ComponentFacade(TypeComponent.OR);
        final ImageView ORI=or.getImage();

        XOR xor= (XOR)new FactoryPalete().ComponentFacade(TypeComponent.XOR);
        final ImageView XORI=xor.getImage();

        NOR nor= (NOR)new FactoryPalete().ComponentFacade(TypeComponent.NOR);
        final ImageView NORI=nor.getImage();

        XNOR xnor= (XNOR)new FactoryPalete().ComponentFacade(TypeComponent.XNOR);
        final ImageView XNORI=xnor.getImage();


        //Componentes del border central

        //VBox vBox = new VBox();
        Pane Centro=new Pane();
        //Centro.setContent(vBox);

        Centro.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                System.out.println("Apunto de soltar");
            }
        });

        Centro.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println(event.getDragboard().getString());
                if (event.getDragboard().getString().equals(AND.Name)) {
                    System.out.println("Hola");
                    StackPane x=new StackPane(and.getImage());
                    x.setPrefSize(event.getSceneX(),event.getSceneY());
                    Centro.getChildren().add(x);
                }

                System.out.println("Dropped");
                System.out.println(event.getSceneX());
                System.out.println(event.getSceneY());
            }
        });

        //Componentes del border derecho
        CompLog=new VBox(ANDI,NANDI,ORI,NORI,XORI,XNORI);
        ScrollPane Derecha=new ScrollPane(CompLog);

        //Creacion del border pane y colocacion de componentes
        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(Centro);
        borderPane.setRight(Derecha);

        //Creacion de la escena principal e iniciar el root
        Scene scene = new Scene(borderPane, 1100, 700);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}