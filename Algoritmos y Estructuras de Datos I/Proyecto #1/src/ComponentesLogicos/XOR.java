package ComponentesLogicos;

import javafx.scene.image.Image;

/**
 * Clase representativa del componente XOR.
 */
public class XOR extends Componente implements Component{

    public static String Name="XOR";

    /**
     * Constructor de la clase que llama al constructor
     * de la clase padre con sus parametros requeridos.
     * @param image - Imagen que representa al componente.
     * @param entrada1 - Entrada por default.
     * @param entrada2 - Entrada por default.
     */
    public XOR(Image image, Componente entrada1, Componente entrada2) {
        super(image, entrada1, entrada2,Name);
    }

    /**
     * Metodo para obtener la salida luego de realizar la operacion
     * logica.
     * @return - int 0 o 1, falso o true respectivamente.
     */
    public int getSalida() {
        if (Entrada1.getSalida() == Entrada2.getSalida()){
            return 0;
        }
        else{
            return 1;
        }
    }

}