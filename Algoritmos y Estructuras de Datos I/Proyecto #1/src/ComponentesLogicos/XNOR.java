package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class XNOR extends Componente implements Component{

    public static String Name="XNOR";

    public XNOR(javafx.scene.image.Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);
    }

    public int getSalida() {
        if (Entrada1 == Entrada2){
            return 1;
        }
        else{
            return 0;
        }
    }

}
