package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OR extends Componente implements Component {

    public static String Name = "OR";

    public OR(javafx.scene.image.Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);
    }

    public int getSalida() {
        if (Entrada1 == 0 && Entrada2==0){
            return 0;
        }
        else{
            return 1;
        }
    }

}