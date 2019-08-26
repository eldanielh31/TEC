package InterfazGrafica;

import ComponentesLogicos.AND;
import ComponentesLogicos.Componente;
import ComponentesLogicos.TypeComponent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RootMain extends Application {

    public static void main(String [] arg){
        launch(arg);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simulador de Circuitos Logicos");


        Button button=new Button("Hola");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Componente and = new FacadePalete().ComponentFacade(TypeComponent.AND);
                and.setPrimeraEntrada(1);
                and.setSegundaEntrada(1);
                System.out.println(and.getSalida());
            }
        });

        VBox vBox = new VBox();

        ScrollPane Centro=new ScrollPane();
        Centro.setContent(vBox);

        VBox CompLog=new VBox(button);
        ScrollPane Derecha=new ScrollPane(CompLog);

        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(Centro);
        borderPane.setRight(Derecha);

        Scene scene = new Scene(borderPane, 1100, 700);




        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}