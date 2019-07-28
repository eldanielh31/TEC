package LectorCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	private MenuBar rootmenu;
	private Menu archivo;
	private MenuItem cargar;
	private FileChooser fileChooser = new FileChooser();
	private File selectedFile;
	private GridPane gridpane;
	
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
            		//System.out.println(selectedFile);
            		readCSV(selectedFile);	
            } 
        });
        
        rootmenu=new MenuBar();
        rootmenu.getMenus().add(archivo);
        

        gridpane=new GridPane();
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        
        VBox vBox = new VBox(rootmenu,gridpane);
        
        ScrollPane scrollpane=new ScrollPane();
        scrollpane.setContent(vBox);
        
        Scene scene = new Scene(scrollpane, 500, 300);
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    private void readCSV(File file){
    	String FieldDelimiter = ",";
    	BufferedReader br;
    	try {
    		//  Block of code to try
    		br = new BufferedReader(new FileReader(file));
    		if(br.readLine()!=null) {
    			int fila=0;
    			String line;
    			while((line = br.readLine()) !=null) {
    				int columna=0;
    				String [] x=line.split(";");
    				for(String i:x) {
    					gridpane.add(new Label(i),fila,columna);
    					columna++;
    				}
    				fila++;}
    			}
    		else {
    			JOptionPane.showMessageDialog(null, "Introduzca un archivo con contenido.");
    		}
    		}
    		catch(Exception e) {
    		  //  Block of code to handle errors
    			JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
    		}
    }
}