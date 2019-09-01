package ComponentesLogicos;

import javafx.scene.image.Image;

public class NOT extends Componente implements Component{

    public static String Name="NOT";

    public NOT(Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);
    }

    public int getSalida() {
        if (Entrada1==1){
            return 0;
        }
        else{
            return 1;
        }
    }

}
