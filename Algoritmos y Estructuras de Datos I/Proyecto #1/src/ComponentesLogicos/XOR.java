package ComponentesLogicos;

import javafx.scene.image.Image;

public class XOR extends Componente implements Component{

    public static String Name="XOR";

    public XOR(Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);
    }

    public int getSalida() {
        if (Entrada1 == Entrada2){
            return 0;
        }
        else{
            return 1;
        }
    }

}