package InterfazGrafica;

import ComponentesLogicos.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        AND and = (AND)new FacadePalete().ComponentFacade(TypeComponent.AND);
        final ImageView AND=and.getImage();


        AND.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db=AND.startDragAndDrop(TransferMode.ANY);

                ClipboardContent content=new ClipboardContent();
                content.putString("Hola");
                db.setContent(content);

                event.consume();
            }
        });


        NAND nand= (NAND)new FacadePalete().ComponentFacade(TypeComponent.NAND);
        final ImageView NAND=nand.getImage();

        OR or= (OR) new FacadePalete().ComponentFacade(TypeComponent.OR);
        final ImageView OR=or.getImage();

        XOR xor= (XOR)new FacadePalete().ComponentFacade(TypeComponent.XOR);
        final ImageView XOR=xor.getImage();

        NOR nor= (NOR)new FacadePalete().ComponentFacade(TypeComponent.NOR);
        final ImageView NOR=nor.getImage();

        XNOR xnor= (XNOR)new FacadePalete().ComponentFacade(TypeComponent.XNOR);
        final ImageView XNOR=xnor.getImage();


        //Boton de prueba
        Button button=new Button("Hola");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Componente and = new FacadePalete().ComponentFacade(TypeComponent.AND);
                and.setPrimeraEntrada(1);
                and.setSegundaEntrada(1);
                System.out.println(and.getSalida());
            }
        });

        //Componentes del border central
        VBox vBox = new VBox();
        ScrollPane Centro=new ScrollPane();
        Centro.setContent(vBox);

        //Componentes del border derecho
        CompLog=new VBox(button,AND,NAND,OR,NOR,XOR,XNOR);
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