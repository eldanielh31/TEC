package ComponentesLogicos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NAND extends Componente implements Component{

    public static String Name="NAND";

    public NAND(javafx.scene.image.Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);
    }
}

