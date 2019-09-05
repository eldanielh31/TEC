package InterfazGrafica;

import ComponentesLogicos.*;
import Lista.ListaEnlazada;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Esta clase funciona como ventana principal de la aplicacion.
 * En ella se encuentra todos los componentes de la clase principal
 */
public class RootMain extends Application {
    //Variables necesarias de clase
    static String[] Names={NOR.Name,XOR.Name,NAND.Name,OR.Name,XNOR.Name,AND.Name,NOT.Name};
    private ImageView [] Imagenes={NORI=nor.getImage(),
            XORI=xor.getImage(),
            NANDI=nand.getImage(),
            ORI=or.getImage(),
            XNORI=xnor.getImage(),
            ANDI=and.getImage(),
            NOTI=not.getImage()};

    public static ListaEnlazada Lista=new ListaEnlazada();
    public static final TextArea AreaText=new TextArea();
    public static final Group Group=new Group();
    public static final Pane Centro=new Pane(Group);
    private VBox CompLog;
    public static ImageView ANDI;
    public static  ImageView NANDI;
    public static  ImageView ORI;
    public static  ImageView XORI;
    public static  ImageView NORI;
    public static ImageView XNORI;
    public static ImageView NOTI;

    /**
     * Este metodo inicia la aplicacion.
     * @param arg
     */
    public static void main(String [] arg){
        launch(arg);
    }

    /**
     * Este metodo contiene todos los componentes de la interfaz grafica
     * de la pantalla principal.
     * @param primaryStage - Este parametro es la ventana principal, donde se colocará la scene
     *                     y sus respectivos componentes.
     */
    @Override
    public void start(Stage primaryStage) throws  Exception{

        primaryStage.setTitle("Simulador de Circuitos Lógicos");

        //Creando imagenes en un array


        //Asignar a cada imagen su evento

        int a=0;
        for (ImageView x:Imagenes){
            int finalA = a;
            x.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Eventos.DragDetected(event,x,Names[finalA]);
                }});
        a++; }

        //Componentes del border central
        Centro.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE); }
        });
        Centro.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Eventos.Dropped(event,Imagenes);
            }
        });

        //Componentes del border derecho
        CompLog=new VBox(ANDI,NANDI,ORI,NORI,XORI,XNORI,NOTI);
        ScrollPane Derecha=new ScrollPane(CompLog);

        //Creacion del border pane y colocacion de componentes
        AreaText.setEditable(false);
        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(Centro);
        borderPane.setRight(Derecha);
        borderPane.setBottom(AreaText);

        //Creacion de la escena principal e iniciar el root
        Scene scene = new Scene(borderPane, 1100, 700);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Creacion de los operadores disponibles en la paleta
    public static final NAND nand= (NAND) new FactoryPalete().ComponentFactory(NAND.Name);
    public static final OR or= (OR) new FactoryPalete().ComponentFactory(OR.Name);
    public static final XOR xor= (XOR)new FactoryPalete().ComponentFactory(XOR.Name);
    public static final NOR nor= (NOR)new FactoryPalete().ComponentFactory(NOR.Name);
    public static final XNOR xnor= (XNOR)new FactoryPalete().ComponentFactory(XNOR.Name);
    public static final AND and = (AND)new FactoryPalete().ComponentFactory(AND.Name);
    public static final NOT not=(NOT) new FactoryPalete().ComponentFactory(NOT.Name);
}