package ComponentesLogicos;

import javafx.scene.image.Image;

/**
 * Clase representativa del componente OR.
 */
public class OR extends Componente implements Component {

    public static String Name = "OR";

    /**
     * Constructor de la clase que llama al contructor
     * de la clase padre.
     * @param image - Imagen del componente.
     * @param entrada1 - Entrada por default.
     * @param entrada2 - Entrada por default.
     */
    public OR(Image image, Componente entrada1, Componente entrada2) {
        super(image, entrada1, entrada2,Name);
    }

    /**
     * Metodo para obtener la salida luego de realizar
     * la operacion logica.
     * @return - int 0 o 1, false o true respectivamente.
     */
    public int getSalida() {
        if (getInput1() == 0 && getInput2()==0){
            return 0;
        }
        else{
            return 1;
        }
    }

}