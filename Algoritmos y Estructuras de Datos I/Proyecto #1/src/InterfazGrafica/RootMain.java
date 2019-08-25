package InterfazGrafica;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootMain extends Application {

    public static void main(String [] arg){
        launch(arg);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simulador de Circuitos Logicos");



        GridPane gridpane=new GridPane();
        gridpane.setGridLinesVisible(true);

        VBox vBox = new VBox(gridpane);

        ScrollPane scrollpane=new ScrollPane();
        scrollpane.setContent(vBox);

        VBox CompLog=new VBox();


        BorderPane borderPane=new BorderPane();
        borderPane.setCenter(scrollpane);
        borderPane.setRight(new Label("Hola, como estas? Me llamo daniel"));

        Scene scene = new Scene(borderPane, 1100, 700);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}