package ComponentesLogicos;

import javafx.scene.image.Image;

/**
 * Clase representativa del componente NAND, con su metodos y atributos
 * correspondientes.
 */
public class NAND extends Componente implements Component{

    public static String Name="NAND";

    /**
     * Constructor de la clase, que llama a la clase padre.
     * @param image - Imagen que representa el componente.
     * @param entrada1 - Entrada por defecto del input.
     * @param entrada2 - Entrada por defecto del input.
     */
    public NAND(Image image, int entrada1, int entrada2) {
        super(image, entrada1, entrada2);
    }

    /**
     * Metodo para obtener la operacion logica del componente.
     * @return - int que representa true or false.
     */
    public int getSalida() {
        if (Entrada1 == 1 && Entrada2==1){
            return 0;
        }
        else{
            return 1;
        }
    }

}

