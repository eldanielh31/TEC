package LectorCSV;

import java.io.*;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
    private MenuBar rootmenu;
    private Menu archivo;
    private MenuItem cargar;
    private FileChooser fileChooser = new FileChooser();
    private File selectedFile;
    private GridPane gridpane;
    private Alert alert = new Alert(Alert.AlertType.WARNING);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lector CSV");


        archivo=new Menu("Archivo");

        cargar=new MenuItem("Cargar");

        archivo.getItems().add(cargar);

        cargar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
                selectedFile = fileChooser.showOpenDialog(primaryStage);
                try {
                    readCSV(selectedFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        rootmenu=new MenuBar();
        rootmenu.getMenus().add(archivo);


        gridpane=new GridPane();
        gridpane.setGridLinesVisible(true);

        VBox vBox = new VBox(rootmenu,gridpane);

        ScrollPane scrollpane=new ScrollPane();
        scrollpane.setContent(vBox);

        Scene scene = new Scene(scrollpane, 500, 300);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void readCSV(File file) throws IOException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            if(br.readLine()!=null) {

                CleanGrid();
                int fila=0;
                String line;
                while((line = br.readLine()) !=null) {
                    int columna=0;
                    String [] x=line.split(",",-1);
                    for(String i:x) {
                        Label h=new Label(i);
                        h.setFont(new Font("Arial",15));
                        gridpane.add(h,columna,fila);
                        columna++;}
                    fila++;}
            }
            else {
                alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Archivo vacío");
                alert.showAndWait();
            }
        }

        catch (NullPointerException e) {
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error al abrir el archivo!");
            alert.showAndWait();
        }
    }

    private void CleanGrid(){
        Node node=gridpane.getChildren().get(0);
        gridpane.getChildren().clear();
        gridpane.getChildren().add(0,node);
    }

}
