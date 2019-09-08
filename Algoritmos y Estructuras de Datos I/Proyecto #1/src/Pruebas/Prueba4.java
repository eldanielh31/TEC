package Pruebas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Prueba4 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Rectangle rectangle = new Rectangle();
        rectangle.setX(80);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(150);
        rectangle.setFill(Color.CADETBLUE);

        rectangle.setArcHeight(105);
        rectangle.setArcWidth(50);



        Group root = new Group();
        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, 400, 250, Color.WHITE);
        primaryStage.setTitle("JavaFX Rectangle (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
