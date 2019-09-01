package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class NOR extends Componente implements Component{

    public static String Name="NOR";

    public NOR(javafx.scene.image.Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);
    }
}
