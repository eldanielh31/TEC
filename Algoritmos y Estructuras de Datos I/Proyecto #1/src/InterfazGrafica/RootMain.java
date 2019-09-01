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

import java.awt.image.ImagingOpException;
import java.text.Normalizer;


public class RootMain extends Application {
    private VBox CompLog;
    public static ImageView ANDI;
    public static  ImageView NANDI;
    public static  ImageView ORI;
    public static  ImageView XORI;
    public static  ImageView NORI;
    public static ImageView XNORI;


    public static void main(String [] arg){
        launch(arg);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simulador de Circuitos Logicos");

        //Creando imagenes en un array
        ImageView [] Imagenes={NORI=nor.getImage(),
        XORI=xor.getImage(),
        NANDI=nand.getImage(),
        ORI=or.getImage(),
        XNORI=xnor.getImage(),
        ANDI=and.getImage()};
        String[] Names={NOR.Name,XNOR.Name,NAND.Name,OR.Name,XNOR.Name,AND.Name};
        int a=0;
        for (ImageView x:Imagenes){
            int finalA = a;
            x.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Eventos.DragDetected(event,x,Names[finalA]);
                }
            });
        a++;
        }
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
    //Creacion de los operadores disponibles en la paleta
    NAND nand= (NAND) new FactoryPalete().ComponentFactory(TypeComponent.NAND);
    OR or= (OR) new FactoryPalete().ComponentFactory(TypeComponent.OR);
    XOR xor= (XOR)new FactoryPalete().ComponentFactory(TypeComponent.XOR);
    NOR nor= (NOR)new FactoryPalete().ComponentFactory(TypeComponent.NOR);
    XNOR xnor= (XNOR)new FactoryPalete().ComponentFactory(TypeComponent.XNOR);
    AND and = (AND)new FactoryPalete().ComponentFactory(TypeComponent.AND);
}