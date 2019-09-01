package ComponentesLogicos;

import javafx.scene.image.Image;


public class AND extends Componente implements Component {

    public static String Name="AND";

    public AND(Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);

    }

    public int getSalida() {
        if (Entrada1 == 1 && Entrada2==1){
            return 1;
        }
        else{
            return 0;
        }
    }

}