
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application  {
    private TextField textField;
    private Label label;
    private Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplo Excepciones");

        button= new Button("Check");
        label= new Label("Introduzca correo electronico:");
        label.setFont(new Font("Courier",15));
        textField=new TextField();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                try {
                    CheckEmail(textField.getText());
                } catch (ExceptionEmail exceptionEmail) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Email erroneo.");
                    alert.showAndWait();
                }
                finally {
                    Alert temail = new Alert(Alert.AlertType.INFORMATION);
                    temail.setTitle("Email");
                    temail.setHeaderText(null);
                    temail.setContentText("Su email es: "+ textField.getText());
                    temail.showAndWait();
                }
            }
        });

        VBox vbox = new VBox(label,textField,button);
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void CheckEmail(String email) throws ExceptionEmail {
        int arroba=0;
        boolean punto=false;

        if (email.length()<=3){
            throw new ExceptionEmail("El email es demasiado corto");
        }
        else{
            for (int x=0; x<email.length();x++){

                if (email.charAt(x)=='@'){
                    arroba++;
                }
                if (email.charAt(x)=='.'){
                    punto=true;
                }
            }
        }

        if (arroba==1 && punto==true){
            Alert correc = new Alert(Alert.AlertType.CONFIRMATION);
            correc.setTitle("Correcto");
            correc.setHeaderText(null);
            correc.setContentText("Su email es correcto");
            correc.showAndWait();
        }
        else{
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setContentText("Su email es incorrecto");
            error.showAndWait();

        }
    }
}


class ExceptionEmail extends Exception{
    public ExceptionEmail(){ }
    public ExceptionEmail(String mensajeError){
        super(mensajeError);
    }

}
